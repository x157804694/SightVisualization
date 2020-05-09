/**
 * @Description:
 * @Package: com.jxufe.sight.web.client
 * @ClassName: tourismVisualizationController
 * @Author: 徐鼎立
 * @Date: 2020/4/25 21:43
 * @version: 1.0
 * Copyright (c) 2020,All Rights Reserved.
 */
package com.jxufe.sight.web.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class tourismVisualizationController {
    @RequestMapping("/tourismVisualization")
    public String tourismVisualization(){
        return "client/tourismVisualization";
    }
}
