//
//  ChampionsController.swift
//  LeagueInformer
//
//  Created by Dmitry Lernatovich on 7/13/17.
//  Copyright © 2017 Dmitry Lernatovich. All rights reserved.
//

import UIKit

class ChampionsController: UIViewController {

    //MARK: - Create functions
    
    /// Method which provide the actions when controller was load
    override func viewDidLoad() {
        super.viewDidLoad();
    }
    
    /// Method provide the actions when controller will appear
    ///
    /// - Parameter animated: is animated
    override func viewWillAppear(_ animated: Bool) {
        MainController.openChampions();
    }
    
    /// Method which provide the actions when controller catch the memory warning
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning();
    }

}
