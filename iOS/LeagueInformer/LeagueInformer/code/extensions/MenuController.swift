//
//  MenuController.swift
//  LeagueInformer
//
//  Created by Dmitry Lernatovich on 12.07.17.
//  Copyright © 2017 Dmitry Lernatovich. All rights reserved.
//

import UIKit

class MenuController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    // MARK: - Constants
    
    /// {@link String} value of the cell identifier
    private static let K_CELL_IDENTIFIER: String! = "cellMenu";

    /// Enum which provide the containing of the images of the menu items
    fileprivate enum Images: String {
        case home = "img_menu_home"
        case news = "img_menu_news"
    }
    
    /// Enum which provide the keeping title for the menu items
    fileprivate enum Titles: String {
        case home = "Home"
        case news = "News"
    }

    //MARK: - Variables
    
    /// Instance of the {@link UITableView}
    @IBOutlet weak var tableView: UITableView!
    
    // MARK: - Create functions
    
    /// Method which provide the actions when controller was load
    override func viewDidLoad() {
        super.viewDidLoad();
        self.initialize();
        self.tableView.setup(withDelegate: self, withDatasource: self);
    }
    
    /// Method which provide the actions when controller catch the memory warning
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning();
    }
    
    // MARK: - Table view
    
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
        return 2;
    }
    
    /// Method which provide the define of the cell for index
    ///
    /// - Parameters:
    ///   - tableView: instance of the {@link UITableView}
    ///   - indexPath: instance of the {@link IndexPath}
    /// - Returns: cell for index
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: MenuController.K_CELL_IDENTIFIER, for: indexPath);
        if let image = cell.viewWithTag(1) as? UIImageView {
            if(indexPath.row == 0){
                image.image = UIImage(named: Images.home.rawValue);
            }else if(indexPath.row == 1){
                image.image = UIImage(named: Images.news.rawValue);
            }
        }
        
        if let label = cell.viewWithTag(2) as? UILabel {
            if(indexPath.row == 0){
                label.text = Titles.home.rawValue;
            }else if(indexPath.row == 1){
                label.text = Titles.news.rawValue;            }
        }

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
