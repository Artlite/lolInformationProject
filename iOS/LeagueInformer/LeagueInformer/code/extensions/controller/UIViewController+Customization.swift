//
//  UIViewController+Customization.swift
//  LeagueInformer
//
//  Created by Dmitry Lernatovich on 7/24/17.
//  Copyright © 2017 Dmitry Lernatovich. All rights reserved.
//

import UIKit

/// Instance of the {@link NSObject}
private var toTransfert: AnyObject?;

/// Instance of the {@link NSObject}
private var transfertedObject: AnyObject?;

// MARK: - Extension which provide the {@link UIVIewController} customization
extension UIViewController {
    
    /// Instance of the {@link NSObject}
    fileprivate var transferting: AnyObject? {
        set {
            toTransfert = newValue;
        }
        get {
            return toTransfert;
        }
    }
    
    /// Instance of the {@link NSObject}
    internal var transferted: AnyObject? {
        set {
            transfertedObject = newValue;
        }
        get {
            return transfertedObject;
        }
    }
    
    /// Method which provide the controller initaialization
    internal final func initialize() {
        self.registerForNotifications();
        self.registerForKeyboardNotifications();
    }
    
    // MARK: - Navigation
    
    /**
     Method which provide the navigation by segue ID
     
     - parameter sequeID: segue ID
     
     - returns: nothing to return
     */
    internal final func navigate(sequeID: String!) {
        self.navigate(sequeID: sequeID, transfeted: nil);
    }
    
    /**
     Method which provide the navigation by segue ID
     
     - author: Dmitriy Lernatovich
     
     - parameter sequeID:   sequeID: segue ID
     - parameter object:    transferted object
     */
    internal final func navigate(sequeID: String!, transfeted object: AnyObject?) {
        self.transferting = object;
        DispatchQueue.main.async(execute: {
            self.performSegue(withIdentifier: sequeID, sender: self);
        })
    }
    
    /**
     Method which provide the navigation by segue ID
     
     - parameter sequeID: segue ID
     
     - returns: nothing to return
     */
    internal final func navigate(push sequeID: String!) {
        DispatchQueue.main.async(execute: {
            self.navigationController?.performSegue(withIdentifier: sequeID, sender: self);
        })
    }
    
    /**
     Method which provide the navigation by segue ID
     
     - parameter sequeID: segue ID
     
     - returns: nothing to return
     */
    internal final func navigateWithClosing(sequeID: String!) {
        self.dismiss(animated: false) {
            DispatchQueue.main.async(execute: {[weak self] in
                if let strongSelf = self {
                    strongSelf.performSegue(withIdentifier: sequeID,
                                            sender: strongSelf);
                }
            })
        }
    }
    
    // MARK: - Prepare for seque method
    /**
     Method which provide the preparartion for notification
     WARNING: Should be using inside the override public func prepare(for segue: UIStoryboardSegue, sender: Any?)  method
     
     - parameter segue:  segue
     - parameter sender: sender
     */
    internal func prepare(for customSegue: UIStoryboardSegue, sender: Any?) {
        let destinationNavigationController: UINavigationController? = customSegue.destination as? UINavigationController;
        if (destinationNavigationController != nil) {
            let targetController: UIViewController? = destinationNavigationController?.topViewController;
            targetController?.transferted = self.transferting;
        } else {
            let targetController: UIViewController? = customSegue.destination;
            targetController?.transferted = self.transferting;
        }
        self.transferting = nil;
    }
    
    // MARK: - Close controller
    
    /**
     Method which provide the close of the controller
     */
    internal final func closeController() {
        if let controller = self.navigationController {
            controller.popViewController(animated: true);
        }
        self.closePopController();
    }
    
    /**
     Method which provide the back pressed navigation
     */
    internal final func onBackPressed() {
        if let controller = self.navigationController {
            controller.popViewController(animated: true);
        }
    }
    
    /**
     Method which provide the closing of the pop controller
     */
    internal final func closePopController() {
        self.dismiss(animated: true, completion: nil);
    }
    
    // MARK: - Functional with post processing
    /**
     Method which provide the action with post processing functional
     
     - author: Dmitriy Lernatovich
     
     - parameter object: object fro post processing
     */
    internal final func onBackPressedWithProcessing(object: AnyObject?, event: ControllerResultEvent) {
        let controllers: [UIViewController]? = self.navigationController?.viewControllers;
        if (controllers != nil) {
            let size: Int = controllers!.count;
            if (size >= 2) {
                let baseController: UIViewController? = controllers![size - 2];
                self.onBackPressed();
                baseController?.onControllerResult(object: object, event: event);
                return;
            }
        }
        self.onBackPressed();
    }
    
    /**
     Method which provide the closing of the previous controller and close current controller with it
     
     - author: Dmitriy Lernatovich
     */
    internal final func onBackPressedFromPrevious() {
        var controllerToClose: UIViewController? = nil;
        let controllers: [UIViewController]? = self.navigationController?.viewControllers;
        if (controllers != nil) {
            let size: Int = controllers!.count;
            if (size >= 3) {
                controllerToClose = controllers![size - 3];
            }
            if (controllerToClose != nil) {
                self.navigationController?.popToViewController(controllerToClose!, animated: true);
                return;
            }
        }
        self.onBackPressed();
    }
    
    /**
     Method which provide on controller result
     (WARNING: SHOULD BE OVERRIDEN IF NEEDED)
     
     - author: Dmitriy Lernatovich
     
     - parameter object: object for result
     */
    open func onControllerResult(object: AnyObject?, event: ControllerResultEvent) {
        
    }
    
    // MARK: - Keyboard functional
    /**
     Method which provide the keyboard hiding
     */
    internal final func hideKeyboard() {
        self.view.endEditing(true);
    }
    
    /**
     Method which provide to add of the taping to hide keyboard
     */
    internal final func addTapHideKeyboard() {
        UISwipeGestureRecognizer.addClick(target: self, view: self.view, selector: #selector(UIViewController.hideKeyboard));
        UISwipeGestureRecognizer.addSwipe(target: self, view: self.view, direction: UISwipeGestureRecognizerDirection.down, selector: #selector(UIViewController.hideKeyboard));
    }
    
    // MARK: Notifications
    /**
     Method which provide the registration for notification
     
     - parameter selector:         selector
     - parameter notificationType: notification type
     */
    internal final func registerNotification(selector: Selector, notificationType: Notification.Name!) {
        NotificationCenter.default.addObserver(self, selector: selector, name: notificationType, object: nil);
    }
    
    /**
     Method which provide the notification sending
     
     - parameter notificationType: notification type
     */
    internal final func sendNotification(notification notificationType: Notification.Name!) {
        NotificationCenter.default.post(name: notificationType, object: nil);
    }
    
    /**
     Method which provide the removing from notification
     */
    internal final func removeFromNotifications() {
        NotificationCenter.default.removeObserver(self);
    }
    
    /**
     Method which provide the notification registration
     (should be overriden in child class)
     */
    open func registerForNotifications() {
        
    }
    
    /**
     Method which provide the registering for keyboard notification
     */
    internal final func registerForKeyboardNotifications() {
        self.registerNotification(selector: #selector(UIViewController.willShowKeyboard(notification:)), notificationType: NSNotification.Name.UIKeyboardWillShow);
        self.registerNotification(selector: #selector(UIViewController.onHideKeyboard), notificationType: NSNotification.Name.UIKeyboardWillHide);
    }
    
    /**
     Method which provide the will show keyboard notification
     
     - parameter notification: notification
     */
    internal final func willShowKeyboard(notification: NSNotification) {
        if let dict = notification.userInfo as NSDictionary? {
            if let nsValue = dict.object(forKey: UIKeyboardFrameBeginUserInfoKey) as? NSValue {
                let keyboardSize: CGSize = nsValue.cgRectValue.size;
                self.onShowKeyboard(keyboardSize: keyboardSize);
            }
        }
    }
    
    /**
     Method which provide to show keyboard
     
     - parameter size: keyboard size
     */
    open func onShowKeyboard(keyboardSize size: CGSize) {
        
    }
    
    /**
     Method which provide the hide keyboard
     */
    open func onHideKeyboard() {
        
    }
    
    /**
     Method which provide to closing of the keyboard
     */
    internal final func closeKeyboard() {
        self.view.endEditing(true);
    }
    
    // MARK: - Visibility checking
    
    /**
     Method which provide the checking of the controller visibility
     
     - returns: controller visibility
     */
    internal final func isVisibleController() -> Bool {
        if ((self.isViewLoaded == true) && (self.view.window != nil)) {
            return true;
        }
        return false;
    }
    
    // MARK: - Event class
    
    /// Class for oncontroller result event
    public class ControllerResultEvent: NSObject {
        private(set) var code: Int = -1;
        /**
         Contructor
         
         - author: Dmitriy Lernatovich
         
         - parameter eventCode: event code
         
         - returns: event object
         */
        init(eventCode: Int) {
            self.code = eventCode;
        }
        
        /**
         Method which provide the comparasions of the objects
         
         - author: Dmitriy Lernatovich
         
         - parameter object: object for compare
         
         - returns: compaing value
         */
        override public func isEqual(_ object: Any?) -> Bool {
            if let compare = object as? ControllerResultEvent {
                if (self.code == compare.code) {
                    return true;
                }
            }
            return false;
        }
    }
}
