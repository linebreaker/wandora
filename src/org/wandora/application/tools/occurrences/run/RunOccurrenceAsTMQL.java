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
 */


package org.wandora.application.tools.occurrences.run;

import java.net.MalformedURLException;
import java.util.Arrays;
import org.wandora.application.Wandora;
import org.wandora.application.WandoraTool;
import org.wandora.application.contexts.Context;
import org.wandora.application.gui.OccurrenceTable;
import org.wandora.application.gui.table.MixedTopicTable;
import org.wandora.application.gui.table.TableViewerPanel;
import org.wandora.application.tools.AbstractWandoraTool;
import org.wandora.topicmap.TMQLRunner;
import org.wandora.topicmap.TopicMap;
import org.wandora.utils.DataURL;

/**
 *
 * @author akivela
 */


public class RunOccurrenceAsTMQL extends AbstractWandoraTool implements WandoraTool {
    
    

    public RunOccurrenceAsTMQL() {}
    public RunOccurrenceAsTMQL(Context preferredContext) {
        setContext(preferredContext);
    }
    
    
    @Override
    public String getName() {
        return "Run TMQL script in occurrence";
    }

    @Override
    public String getDescription() {
        return "Run TMQL (Topic Map Query Language) script stored in occurrence.";
    }
    
    
    @Override
    public void execute(Wandora wandora, Context context) {
        Object contextSource = context.getContextSource();
        
        // ***** OCCURRENCE TABLE ***** 
        if(contextSource instanceof OccurrenceTable) {
            OccurrenceTable ot = (OccurrenceTable) contextSource;
            String occurrence = ot.getPointedOccurrence();
            if(DataURL.isDataURL(occurrence)) {
                DataURL dataURL = null;
                try {
                    dataURL = new DataURL(occurrence);
                } 
                catch (MalformedURLException ex) {
                    log(ex);
                }
                if(dataURL != null) {
                    occurrence = new String(dataURL.getData());
                }
            }
            System.out.println("Running TMQL script:\n"+occurrence);
            try {
                TopicMap tm = wandora.getTopicMap();
                TMQLRunner.TMQLResult result = TMQLRunner.runTMQL(tm, occurrence);
                Object[][] data = result.getData();
                Object[] columns = Arrays.copyOf(result.getColumns(), result.getNumColumns(), Object[].class);

                MixedTopicTable table = new MixedTopicTable(wandora);
                table.initialize(data,columns);
                String title = "TMQL result";
                        
                TableViewerPanel viewer = new TableViewerPanel();
                viewer.openInDialog(table, title);
            }
            catch(Exception e) {
                wandora.handleError(e);
                e.printStackTrace();
            }
        }
    }
    
    
}
