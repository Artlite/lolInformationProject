//
//  MenuController.swift
//  LeagueInformer
//
//  Created by Dmitry Lernatovich on 12.07.17.
//  Copyright © 2017 Dmitry Lernatovich. All rights reserved.
//

import UIKit

class MenuController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    //MARK: - Constants
    
    /// {@link String} value of the cell identifier
    private static let K_CELL_IDENTIFIER: String! = "cellMenu";

    //MARK: - Variables
    
    /// Instance of the {@link UITableView}
    @IBOutlet weak var tableView: UITableView!
    
    //MARK: - Create functions
    
    /// Method which provide the actions when controller was load
    override func viewDidLoad() {
        super.viewDidLoad();
        self.tableView.delegate = self;
        self.tableView.dataSource = self;
    }
    
    /// Method which provide the actions when controller catch the memory warning
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning();
    }
    
    //MARK: - Table view
    
    /// Method which provide the defining numbers of sections
    ///
    /// - Parameter tableView: instance of the {@link UITableView}
    /// - Returns: numbers of sections
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1;
    }
    
    /// Method which provide the define the numbers of rows
    ///
    /// - Parameters:
    ///   - tableView: instance of the {@link UITableView}
    ///   - section: {@link Int} value of the section number
    /// - Returns: numbers of rows
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 9;
    }
    
    /// Method which provide the define of the cell for index
    ///
    /// - Parameters:
    ///   - tableView: instance of the {@link UITableView}
    ///   - indexPath: instance of the {@link IndexPath}
    /// - Returns: cell for index
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: MenuController.K_CELL_IDENTIFIER, for: indexPath);
        return cell;
    }
    
    /// Method which provide the cell selection
    ///
    /// - Parameters:
    ///   - tableView: instance of the {@link UITableView}
    ///   - indexPath: instance of the {@link IndexPath}
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        NSLog("Selected %@", "\(indexPath)");
    }

}
