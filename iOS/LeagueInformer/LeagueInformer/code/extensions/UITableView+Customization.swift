//
//  UITableView+Customization.swift
//  LeagueInformer
//
//  Created by Dmitry Lernatovich on 7/17/17.
//  Copyright © 2017 Dmitry Lernatovich. All rights reserved.
//

import UIKit

// MARK: - Extension of the UITableView
extension UITableView {
    
    /// Method which provide the setting the cells with delegates, datasource and cells for registering
    ///
    /// - Parameters:
    ///   - withDelegate: instance of the {@link UITableViewDelegate}
    ///   - withDatasource: instance of the {@link UITableViewDataSource}
    public func setup(withDelegate delegate: UITableViewDelegate?,
                      withDatasource datasource: UITableViewDataSource?) {
        self.setup(withDelegate: delegate, withDatasource: datasource,
                   withRegisteringCell: nil, andOwner: nil);
    }
    
    /// Method which provide the setting the cells with delegates, datasource and cells for registering
    ///
    /// - Parameters:
    ///   - withDelegate: instance of the {@link UITableViewDelegate}
    ///   - withDatasource: instance of the {@link UITableViewDataSource}
    ///   - cells: array of the {@link AnyClass} for cell registering
    ///   - owner: {@link AnyObject} of the owner
    public func setup(withDelegate delegate: UITableViewDelegate?,
                      withDatasource datasource: UITableViewDataSource?,
                      withRegisteringCell cells: [AnyClass]?,
                      andOwner owner: AnyObject?) {
        if let datasource = datasource {
            self.dataSource = datasource;
        }
        if let delegate = delegate {
            self.delegate = delegate;
        }
        self.estimatedRowHeight = 100;
        self.rowHeight = UITableViewAutomaticDimension;
        self.register(withCells: cells, andOwner: owner);
    }
    
    
    /// Method which provide the cells registration
    ///
    /// - Parameters:
    ///   - cells: array of the {@link AnyClass} for cell registering
    ///   - owner: {@link AnyObject} of the owner
    public func register(withCells cells: [AnyClass]?,
                         andOwner owner: AnyObject?) {
        if let cells = cells {
            for cell in cells {
                self.register(withCell: cell, andOwner: owner);
            }
        }
    }
    
    /// Method which provide the cell registration
    ///
    /// - Parameters:
    ///   - cell: instance of the {@link AnyClass}
    ///   - owner: {@link AnyObject} of the owner
    public func register(withCell cell: AnyClass?,
                         andOwner owner: AnyObject?) {
        if let cell = cell {
            if let identifier = NSStringFromClass(cell).components(separatedBy: ".").last {
                let nib = UINib.init(nibName: identifier, bundle: Bundle(for: UITableView.self));
                self.register(nib, forCellReuseIdentifier: identifier);
            }
        }
    }
}

// MARK: - Cell extension
extension UITableViewCell {
    
    /**
     Method which provide the customize of the underline for the cell and underline
     (WARNING: Should be using inside the:
     1. setInterface(fromObject object: BaseTableObject!);
     2. setInterface(firstTime object: BaseTableObject!)).
     
     - author: Dmitriy Lernatovich
     
     - parameter needSelection: need selection visualization
     - parameter needUnderline: need underline for cell
     */
    public final func setup(isNeedSeletcion needSelection: Bool,
                            isNeedUnderline needUnderline: Bool) {
        if (needSelection == false) {
            self.selectionStyle = .none;
        }else{
            self.selectionStyle = .default;
        }
        
        if (needUnderline == false) {
            self.separatorInset = UIEdgeInsetsMake(0.0, 0.0, 0.0, self.bounds.size.width);
        }
    }
    
}
