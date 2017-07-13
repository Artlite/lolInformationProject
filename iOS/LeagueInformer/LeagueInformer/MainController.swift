//
//  ViewController.swift
//  LeagueInformer
//
//  Created by Dmitry Lernatovich on 7/12/17.
//  Copyright © 2017 Dmitry Lernatovich. All rights reserved.
//

import UIKit

class MainController: UIViewController {
    
    //MARK: - Constants
    
    /// {@link Int} value of the menu view width
    private static let K_MENU_WIDTH: CGFloat! = 250;
    
    /// {@link Notification.Name} of the open champion screen notification
    private static let K_NOTIFICATION_OPEN_CHAMPIONS: Notification.Name! = Notification.Name(rawValue: "Notification:OpenChampions");
    /// {@link Notification.Name} of the open champion screen notification
    private static let K_NOTIFICATION_OPEN_ITEMS: Notification.Name! = Notification.Name(rawValue: "Notification:OpenItems");
    /// {@link Notification.Name} of the open champion screen notification
    private static let K_NOTIFICATION_OPEN_ABOUT: Notification.Name! = Notification.Name(rawValue: "Notification:OpenAbout");
    
    /// Enum which provide the keep the titles name
    ///
    /// - champion: champion title
    /// - items: items title
    /// - about: about titles
    private enum ScreenTitles: String {
        case champion = "Champions"
        case items = "Items"
        case about = "About"
    }
    
    //MARK: - Static methods
    
    /// Method which provide the open menu champions screen functional
    public static func openChampions() {
        NotificationCenter.default.post(name: MainController.K_NOTIFICATION_OPEN_CHAMPIONS, object: nil);
    }
    
    /// Method which provide the open menu items screen functional
    public static func openItems() {
        NotificationCenter.default.post(name: MainController.K_NOTIFICATION_OPEN_ITEMS, object: nil);
    }
    
    /// Method which provide the open menu about screen functional
    public static func openAbout() {
        NotificationCenter.default.post(name: MainController.K_NOTIFICATION_OPEN_ABOUT, object: nil);
    }

    //MARK: - Variables
    
    /// Instance of the {@link NSLayoutConstraint}
    @IBOutlet weak var constMenuLeft: NSLayoutConstraint!
    
    //MARK: - Init methods
    
    /// Method which provide the actions when controller was load
    override func viewDidLoad() {
        super.viewDidLoad();
        self.onInitGetsures();
        self.onInitNotifications();
    }

    /// Method which provide the actions when controller catch the memory warning
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    /// Method which provide the getsures initialization
    private func onInitGetsures() {
        UISwipeGestureRecognizer.addBorderSwipe(target: self, view: self.view, direction: UIRectEdge.left, selector: #selector(MainController.openMenu));
        UISwipeGestureRecognizer.addSwipe(target: self, view: self.view, direction: UISwipeGestureRecognizerDirection.left, selector: #selector(MainController.closeMenu));
        
    }
    
    /// Method which provide the subscribe for the notifications
    private func onInitNotifications() {
        NotificationCenter.default.addObserver(self, selector: #selector(MainController.setChampionsTitle), name: MainController.K_NOTIFICATION_OPEN_CHAMPIONS, object: nil);
        NotificationCenter.default.addObserver(self, selector: #selector(MainController.setItemsTitle), name: MainController.K_NOTIFICATION_OPEN_ITEMS, object: nil);
        NotificationCenter.default.addObserver(self, selector: #selector(MainController.setAboutTitle), name: MainController.K_NOTIFICATION_OPEN_ABOUT, object: nil);
    }
    
    //MARK: - Menu functional
    
    /// Method which provide the action when press menu button
    ///
    /// - Parameter sender: {@link Any} object of sender
    @IBAction func onMenuPressed(_ sender: Any) {
        self.switchMenu();
    }
    
    /// Method which provide the menu switching
    private func switchMenu() {
        if(self.constMenuLeft.constant < 0){
            self.openMenu();
        }else{
            self.closeMenu();
        }
    }
    
    /// Method which provide the menu opening
    @objc private func openMenu() {
        self.view.layoutIfNeeded();
        UIView.animate(withDuration: 0.5) {[weak self] in
            self?.constMenuLeft.constant = 0;
            self?.view.layoutIfNeeded();
        }
    }
    
    /// Method which provide the menu opening
    @objc private func closeMenu() {
        self.view.layoutIfNeeded();
        UIView.animate(withDuration: 0.5) {[weak self] in
            self?.constMenuLeft.constant = -MainController.K_MENU_WIDTH;
            self?.view.layoutIfNeeded();
        }
    }
    
    //MARK: - Set titles
    
    /// Method which provide the setting of the champions titles
    @objc private func setChampionsTitle() {
        self.title = ScreenTitles.champion.rawValue.uppercased();
    }
    
    /// Method which provide the setting of the champions titles
    @objc private func setItemsTitle() {
        self.title = ScreenTitles.items.rawValue.uppercased();
    }
    
    /// Method which provide the setting of the champions titles
    @objc private func setAboutTitle() {
        self.title = ScreenTitles.about.rawValue.uppercased();
    }
}

