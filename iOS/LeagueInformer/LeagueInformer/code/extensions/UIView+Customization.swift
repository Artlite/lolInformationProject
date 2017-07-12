//
//  UIView+Customization.swift
//  LeagueInformer
//
//  Created by Dmitry Lernatovich on 7/12/17.
//  Copyright © 2017 Dmitry Lernatovich. All rights reserved.
//

import Foundation
import UIKit

// MARK: - Extension which provide the view customization
extension UIView {
    
    /// {@link CGFloat} value of the corner radius
    @IBInspectable var cornerRadius: CGFloat {
        set {
            layer.cornerRadius = newValue
            layer.masksToBounds = newValue > 0
        }
        get {
            return layer.cornerRadius
        }
    }
    
    /// {@link CGFloat} value of the border width
    @IBInspectable var borderWidth: CGFloat {
        set {
            layer.borderWidth = newValue
        }
        get {
            return layer.borderWidth
        }
    }
    
    /// {@link UIColor} instance of the border color
    @IBInspectable var borderColor: UIColor? {
        set {
            layer.borderColor = newValue?.cgColor
        }
        get {
            return UIColor(cgColor: layer.borderColor ?? UIColor.clear.cgColor)
        }
    }
    
    /// Method which provide the rounding corners for the view
    ///
    /// - Parameters:
    ///   - corners: {@link UIRectCorner} instance of the corners
    ///   - radius: {@link CGFloat} instance of the radius
    func roundCorners(_ corners: UIRectCorner, radius: CGFloat) {
        let maskPath = UIBezierPath(roundedRect: self.bounds,
                                    byRoundingCorners: corners,
                                    cornerRadii: CGSize(width: radius, height: radius))
        let shape = CAShapeLayer.init()
        shape.path = maskPath.cgPath
        self.layer.mask = shape
    }
    
}
