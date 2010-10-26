/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ScriptManagerDialog.java
 *
 * Created on 24 mars 2009, 18:25:32
 */

package modbuspal.script;

import java.awt.Component;
import java.awt.dnd.DropTarget;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import modbuspal.binding.BindingFactory;
import modbuspal.instanciator.Instanciator;
import modbuspal.generator.GeneratorFactory;
import modbuspal.instanciator.InstanciatorListener;
import modbuspal.instanciator.InstanciatorManager;
import modbuspal.main.ListLayout;
import modbuspal.main.ModbusPalPane;
import modbuspal.main.ModbusPalProject;
import modbuspal.script.panels.*;
import modbuspal.toolkit.FileTransferHandler;


/**
 *
 * @author nnovic
 */
public class ScriptManagerDialog
extends javax.swing.JDialog
implements InstanciatorListener, ScriptListener, FileTransferHandler.FileTransferTarget
{
    private static final String REGISTRY_KEY = ModbusPalPane.BASE_REGISTRY_KEY + "/instanciators";
    public static final int TAB_GENERATORS = 2;
    public static final int TAB_BINDINGS = 3;
    private ModbusPalProject modbusPalProject;
    
    /** Creates new form ScriptManagerDialog */
    public ScriptManagerDialog()
    {
        super();
        initComponents();
        startupScriptsList.setDropTarget( new DropTarget(this, new FileTransferHandler(this) ) );
        ondemandScriptsList.setDropTarget( new DropTarget(this, new FileTransferHandler(this) ) );
        generatorInstanciatorsList.setDropTarget( new DropTarget(this, new FileTransferHandler(this) ) );
        bindingInstanciatorsList.setDropTarget( new DropTarget(this, new FileTransferHandler(this) ) );
    }

    public void setSelectedTab(int tabIndex)
    {
        jTabbedPane1.setSelectedIndex(tabIndex);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        startupScriptsTab = new javax.swing.JPanel();
        startupScriptsScrollPane = new javax.swing.JScrollPane();
        startupScriptsList = new javax.swing.JPanel();
        startupScriptsButtons = new javax.swing.JPanel();
        addStartupScriptButton = new javax.swing.JButton();
        ondemandScriptsTab = new javax.swing.JPanel();
        ondemandScriptsScrollPane = new javax.swing.JScrollPane();
        ondemandScriptsList = new javax.swing.JPanel();
        ondemandScriptsButtons = new javax.swing.JPanel();
        addOndemandScriptButton = new javax.swing.JButton();
        generatorInstanciatorsTab = new javax.swing.JPanel();
        generatorInstanciatorsScrollPane = new javax.swing.JScrollPane();
        generatorInstanciatorsList = new javax.swing.JPanel();
        generatorInstanciatorButtons = new javax.swing.JPanel();
        addGeneratorInstanciatorButton = new javax.swing.JButton();
        bindingInstanciatorsTab = new javax.swing.JPanel();
        bindingInstanciatorsScrollPane = new javax.swing.JScrollPane();
        bindingInstanciatorsList = new javax.swing.JPanel();
        bindingInstanciatorButtons = new javax.swing.JPanel();
        addBindingInstanciatorButton = new javax.swing.JButton();
        statusPanel = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Script Manager");
        setMinimumSize(new java.awt.Dimension(400, 250));

        startupScriptsTab.setLayout(new java.awt.BorderLayout());

        startupScriptsList.setBackground(javax.swing.UIManager.getDefaults().getColor("List.background"));
        startupScriptsList.setLayout(null);
        startupScriptsList.setLayout( new ListLayout() );
        startupScriptsScrollPane.setViewportView(startupScriptsList);

        startupScriptsTab.add(startupScriptsScrollPane, java.awt.BorderLayout.CENTER);

        startupScriptsButtons.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        addStartupScriptButton.setText("Add");
        addStartupScriptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStartupScriptButtonActionPerformed(evt);
            }
        });
        startupScriptsButtons.add(addStartupScriptButton);

        startupScriptsTab.add(startupScriptsButtons, java.awt.BorderLayout.NORTH);

        jTabbedPane1.addTab("Startup scripts", startupScriptsTab);

        ondemandScriptsTab.setLayout(new java.awt.BorderLayout());

        ondemandScriptsList.setBackground(javax.swing.UIManager.getDefaults().getColor("List.background"));
        ondemandScriptsList.setLayout(null);
        ondemandScriptsList.setLayout( new ListLayout() );
        ondemandScriptsScrollPane.setViewportView(ondemandScriptsList);

        ondemandScriptsTab.add(ondemandScriptsScrollPane, java.awt.BorderLayout.CENTER);

        ondemandScriptsButtons.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        addOndemandScriptButton.setText("Add");
        addOndemandScriptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOndemandScriptButtonActionPerformed(evt);
            }
        });
        ondemandScriptsButtons.add(addOndemandScriptButton);

        ondemandScriptsTab.add(ondemandScriptsButtons, java.awt.BorderLayout.NORTH);

        jTabbedPane1.addTab("On demand scripts", ondemandScriptsTab);

        generatorInstanciatorsTab.setLayout(new java.awt.BorderLayout());

        generatorInstanciatorsList.setBackground(javax.swing.UIManager.getDefaults().getColor("List.background"));
        generatorInstanciatorsList.setLayout(null);
        generatorInstanciatorsList.setLayout( new ListLayout() );
        generatorInstanciatorsScrollPane.setViewportView(generatorInstanciatorsList);

        generatorInstanciatorsTab.add(generatorInstanciatorsScrollPane, java.awt.BorderLayout.CENTER);

        generatorInstanciatorButtons.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        addGeneratorInstanciatorButton.setText("Add");
        addGeneratorInstanciatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGeneratorInstanciatorButtonActionPerformed(evt);
            }
        });
        generatorInstanciatorButtons.add(addGeneratorInstanciatorButton);

        generatorInstanciatorsTab.add(generatorInstanciatorButtons, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Generator scripts", generatorInstanciatorsTab);

        bindingInstanciatorsTab.setLayout(new java.awt.BorderLayout());

        bindingInstanciatorsList.setBackground(javax.swing.UIManager.getDefaults().getColor("List.background"));
        bindingInstanciatorsList.setLayout(null);
        bindingInstanciatorsList.setLayout( new ListLayout() );
        bindingInstanciatorsScrollPane.setViewportView(bindingInstanciatorsList);

        bindingInstanciatorsTab.add(bindingInstanciatorsScrollPane, java.awt.BorderLayout.CENTER);

        bindingInstanciatorButtons.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        addBindingInstanciatorButton.setText("Add");
        addBindingInstanciatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBindingInstanciatorButtonActionPerformed(evt);
            }
        });
        bindingInstanciatorButtons.add(addBindingInstanciatorButton);

        bindingInstanciatorsTab.add(bindingInstanciatorButtons, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Binding scripts", bindingInstanciatorsTab);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        statusPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        statusLabel.setText(".");
        statusPanel.add(statusLabel);

        getContentPane().add(statusPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addStartupScriptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStartupScriptButtonActionPerformed

        // get the selected file, in any.
        File scriptFile = chooseScriptFile(this);
        if( scriptFile==null )
        {
            setStatus("Cancelled by user.");
            return;
        }

        // add startup script:
        modbusPalProject.addStartupScript(scriptFile);
    }//GEN-LAST:event_addStartupScriptButtonActionPerformed


    public static File chooseScriptFile(Component parent)
    {
        // get last used directory
        Preferences prefs = Preferences.userRoot();
        Preferences appPrefs = prefs.node(REGISTRY_KEY);
        String prev_dir = appPrefs.get("prev_dir", null);

        // newInstance the dialog
        JFileChooser fileChooser = new JFileChooser();

        // setup current directory if available
        if( prev_dir != null )
        {
            File cwd = new File(prev_dir);
            if( (cwd.isDirectory()==true) && (cwd.exists()==true) )
            {
                fileChooser.setCurrentDirectory(cwd);
            }
        }

        // newInstance a Python/Jython extension filter
        FileNameExtensionFilter pythonFilter = new FileNameExtensionFilter("Python file", "py");
        fileChooser.setFileFilter(pythonFilter);

        // display file chooser
        int choice = fileChooser.showDialog(parent, "Add");
        if( choice == JFileChooser.APPROVE_OPTION)
        {
            // get the directory that has been chosen
            File chosen = fileChooser.getCurrentDirectory();
            appPrefs.put("prev_dir", chosen.getPath());
            try {
                appPrefs.flush();
            } catch (BackingStoreException ex) {
                Logger.getLogger(GeneratorFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
            return fileChooser.getSelectedFile();
        }

        return null;
    }



    private void addGeneratorInstanciatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGeneratorInstanciatorButtonActionPerformed

        // get the selected file, in any.
        File scriptFile = chooseScriptFile(this);
        if( scriptFile==null )
        {
            setStatus("Cancelled by user.");
            return;
        }

        modbusPalProject.addGeneratorInstanciator(scriptFile);
    }//GEN-LAST:event_addGeneratorInstanciatorButtonActionPerformed

    private void addOndemandScriptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOndemandScriptButtonActionPerformed

        // get the selected file, in any.
        File scriptFile = chooseScriptFile(this);
        if( scriptFile==null )
        {
            setStatus("Cancelled by user.");
            return;
        }
        
        // add script to project
        modbusPalProject.addScript(scriptFile);

}//GEN-LAST:event_addOndemandScriptButtonActionPerformed

    private void addBindingInstanciatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBindingInstanciatorButtonActionPerformed

        // get the selected file, in any.
        File scriptFile = chooseScriptFile(this);
        if( scriptFile==null )
        {
            setStatus("Cancelled by user.");
            return;
        }

        modbusPalProject.addBindingInstanciator(scriptFile);

}//GEN-LAST:event_addBindingInstanciatorButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBindingInstanciatorButton;
    private javax.swing.JButton addGeneratorInstanciatorButton;
    private javax.swing.JButton addOndemandScriptButton;
    private javax.swing.JButton addStartupScriptButton;
    private javax.swing.JPanel bindingInstanciatorButtons;
    private javax.swing.JPanel bindingInstanciatorsList;
    private javax.swing.JScrollPane bindingInstanciatorsScrollPane;
    private javax.swing.JPanel bindingInstanciatorsTab;
    private javax.swing.JPanel generatorInstanciatorButtons;
    private javax.swing.JPanel generatorInstanciatorsList;
    private javax.swing.JScrollPane generatorInstanciatorsScrollPane;
    private javax.swing.JPanel generatorInstanciatorsTab;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel ondemandScriptsButtons;
    private javax.swing.JPanel ondemandScriptsList;
    private javax.swing.JScrollPane ondemandScriptsScrollPane;
    private javax.swing.JPanel ondemandScriptsTab;
    private javax.swing.JPanel startupScriptsButtons;
    private javax.swing.JPanel startupScriptsList;
    private javax.swing.JScrollPane startupScriptsScrollPane;
    private javax.swing.JPanel startupScriptsTab;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void instanciatorAdded(InstanciatorManager factory, Instanciator def)
    {
        if( factory instanceof GeneratorFactory )
        {
            ScriptRunner si = (ScriptRunner)def;
            // create a new panel and add it
            ScriptRunnerPanel panel = new GeneratorScriptRunnerPanel(si,modbusPalProject);
            generatorInstanciatorsList.add(panel);
            validate(); repaint();
        }

        else if( factory instanceof BindingFactory )
        {
            ScriptRunner si = (ScriptRunner)def;
            // create a new panel and add it
            ScriptRunnerPanel panel = new BindingScriptRunnerPanel(si,modbusPalProject);
            bindingInstanciatorsList.add(panel);
            validate(); repaint();
        }
    }

    @Override
    public void instanciatorRemoved(InstanciatorManager factory, Instanciator def)
    {
        if( factory instanceof GeneratorFactory )
        {
            ScriptRunner si = (ScriptRunner)def;
            generatorInstanciatorRemoved(si);
        }

        else if( factory instanceof BindingFactory )
        {
            ScriptRunner si = (ScriptRunner)def;
            bindingInstanciatorRemoved(si);
        }
    }

    private void generatorInstanciatorRemoved(ScriptRunner si)
    {
        int max = generatorInstanciatorsList.getComponentCount();
        for(int i=0; i<max; i++ )
        {
            Component comp = generatorInstanciatorsList.getComponent(i);
            if( comp instanceof ScriptRunnerPanel )
            {
                ScriptRunnerPanel sip = (ScriptRunnerPanel)comp;
                if( sip.contains(si)==true )
                {
                    generatorInstanciatorsList.remove(sip);
                }
            }
        }
        validate(); repaint();
    }


    private void bindingInstanciatorRemoved(ScriptRunner si)
    {
        int max = bindingInstanciatorsList.getComponentCount();
        for(int i=0; i<max; i++ )
        {
            Component comp = bindingInstanciatorsList.getComponent(i);
            if( comp instanceof ScriptRunnerPanel )
            {
                ScriptRunnerPanel sip = (ScriptRunnerPanel)comp;
                if( sip.contains(si)==true )
                {
                    bindingInstanciatorsList.remove(sip);
                }
            }
        }
        validate(); repaint();
    }



    private void setStatus(String status)
    {
        statusLabel.setText(status);
    }

    @Override
    public void startupScriptAdded(ScriptRunner runner)
    {
        // create a new panel and add it
        ScriptRunnerPanel panel = new StartupScriptRunnerPanel(runner,modbusPalProject);
        startupScriptsList.add(panel);
        validate(); repaint();
    }

    @Override
    public void scriptAdded(ScriptRunner runner)
    {
        // create a new panel and add it
        ScriptRunnerPanel panel = new OnDemandScriptRunnerPanel(runner,modbusPalProject);
        ondemandScriptsList.add(panel);
        validate(); repaint();
    }


    private ScriptRunnerPanel findPanel(JPanel panel, ScriptRunner runner)
    {
        for( int i=0; i<panel.getComponentCount(); i++ )
        {
            Component comp = panel.getComponent(i);
            if( comp instanceof ScriptRunnerPanel )
            {
                ScriptRunnerPanel srp = (ScriptRunnerPanel)comp;
                if( srp.contains(runner)==true )
                {
                    return srp;
                }
            }
        }
        return null;
    }


    public void scriptRemoved(ScriptRunner runner)
    {
        ScriptRunnerPanel panel = findPanel(ondemandScriptsList,runner);
        ondemandScriptsList.remove(panel);
        validate(); repaint();
    }

    public void startupScriptRemoved(ScriptRunner runner)
    {
        ScriptRunnerPanel panel = findPanel(startupScriptsList,runner);
        startupScriptsList.remove(panel);
        validate(); repaint();
    }

    @Override
    public boolean importFiles(Component target, List<File> files)
    {
        for( int i=0; i<files.size(); i++ )
        {
            File scriptFile = files.get(i);

            if( target==startupScriptsList)
            {
                modbusPalProject.addStartupScript(scriptFile);
            }
            else if( target==ondemandScriptsList )
            {
                modbusPalProject.addScript(scriptFile);
            }
            else if( target==generatorInstanciatorsList)
            {
                modbusPalProject.addGeneratorInstanciator(scriptFile);
            }
            else if( target==bindingInstanciatorsList )
            {
                modbusPalProject.addBindingInstanciator(scriptFile);
            }
            else
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        }

        return true;
    }

    public void setProject(ModbusPalProject mpp)
    {
        if( modbusPalProject!=null )
        {
            modbusPalProject.removeScriptListener(this);
            modbusPalProject.getGeneratorFactory().removeInstanciatorListener(this);
            modbusPalProject.getBindingFactory().removeInstanciatorListener(this);
        }
        modbusPalProject = mpp;
        modbusPalProject.addScriptListener(this);
        modbusPalProject.getGeneratorFactory().addInstanciatorListener(this);
        modbusPalProject.getBindingFactory().addInstanciatorListener(this);


        // update list of startup scripts:
        startupScriptsList.removeAll();
        for(ScriptRunner runner:modbusPalProject.getStartupScripts())
        {
            startupScriptAdded(runner);
        }

        // update list of on-demand scripts:
        ondemandScriptsList.removeAll();
        for(ScriptRunner runner:modbusPalProject.getScripts())
        {
            scriptAdded(runner);
        }

        // update list of generators:
        generatorInstanciatorsList.removeAll();
        GeneratorFactory genFac = modbusPalProject.getGeneratorFactory();
        for(Instanciator i:genFac.getScripts())
        {
            instanciatorAdded(genFac, i);
        }

        // update list of bindings:
        bindingInstanciatorsList.removeAll();
        BindingFactory binFac = modbusPalProject.getBindingFactory();
        for(Instanciator i:binFac.getScripts())
        {
            instanciatorAdded(binFac, i);
        }


        
    }

}
