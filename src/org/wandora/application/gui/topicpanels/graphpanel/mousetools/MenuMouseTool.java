/*
 * WANDORA
 * Knowledge Extraction, Management, and Publishing Application
 * http://wandora.org
 * 
 * Copyright (C) 2004-2016 Wandora Team
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * 
 * MenuMouseTool.java
 *
 * Created on 25. kes�kuuta 2007, 9:39
 *
 */

package org.wandora.application.gui.topicpanels.graphpanel.mousetools;

import org.wandora.application.gui.topicpanels.graphpanel.*;
import javax.swing.*;

/**
 *
 * @author olli
 */
public class MenuMouseTool extends MouseTool {
    
    /** Creates a new instance of MenuMouseTool */
    public MenuMouseTool() {
    }


    @Override
    public boolean mouseClicked(TopicMapGraphPanel panel, int mousex, int mousey) {
        VNode mouseOverNode=panel.getMouseOverNode();
        VEdge mouseOverEdge=panel.getMouseOverEdge();
        VModel model=panel.getModel();
        if(mouseOverNode!=null){
            if(!mouseOverNode.isSelected()) model.setSelection(mouseOverNode);
            JPopupMenu menu=panel.getNodeMenu();
            menu.show(panel,mousex,mousey);
        }
        else if(mouseOverEdge!=null){
            if(!mouseOverEdge.isSelected()) model.setSelection(mouseOverEdge);
            JPopupMenu menu=panel.getEdgeMenu();
            menu.show(panel,mousex,mousey);
        }
        else {            
            JPopupMenu menu=panel.getGeneralMenu();
            menu.show(panel,mousex,mousey);
        }        
        return true;
    }
    
}
