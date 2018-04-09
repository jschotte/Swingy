package com.jschotte.swingy.view;

import java.awt.Dimension;
import java.util.ArrayList;


import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.jschotte.swingy.model.character.Hero;
import com.jschotte.swingy.model.character.heroFactory;

public class GUIView extends JFrame
{
	private JPanel panel;
	private JButton selectHero;
	private JButton newHero;
	private JList jList1;
    private JTextArea jTextArea1;
    
    private ArrayList<Hero> heroesTmp = new ArrayList<Hero>();
    
    private JTextField heroName;
    private JComboBox classLst;
	private JButton createHero;
	
	public GUIView()
	{
		this.panel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.add(panel);
		
		
		this.setVisible(true);
	}
	
	@SuppressWarnings("rawtypes")
	public void GUISelection(ArrayList<Hero> heroes)
	{
		this.panel.removeAll();
		this.repaint();
		
		this.heroesTmp = heroes;
		
        this.setSelectHero(new JButton());
		this.getSelectHero().setText("select hero");
		this.selectHero.setEnabled(false);
		
		this.setNewHero(new JButton());
		this.getNewHero().setText("create hero");
		
        jList1 = new JList();
        jTextArea1 = new JTextArea();
        
        DefaultListModel<String> model = new DefaultListModel<>();
        for ( int i = 0; i < heroes.size(); i++ )
        {
        	model.addElement( heroes.get(i).toString());
        }
        
        jList1 = new JList<>( model );

        jList1.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {
            	jList1ValueChanged(evt);
            }
        });
        
        jTextArea1.setColumns(20);
        jTextArea1.setRows(10);

        JScrollPane scrollPane = new JScrollPane(jList1, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        scrollPane.setPreferredSize(new Dimension(280, 150));
        
        this.panel.add(scrollPane);
        this.panel.add(jTextArea1);
        this.panel.add(selectHero);
        this.panel.add(newHero);
		
		this.setPreferredSize(new Dimension(300, 400));
		this.setResizable(false);
		this.pack();
		
	}
	
    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt)
    {
		this.selectHero.setEnabled(true);
        Hero selectedHero = heroesTmp.get(jList1.getSelectedIndex());
        
        jTextArea1.setText(selectedHero.getName() + "\n" + selectedHero.getClass().getSimpleName() + "\nlv: "
				+ selectedHero.getLevel() + "\nexp: " + selectedHero.getExp() + "\ndmg: "
				+ selectedHero.getAttack() + "\ndef: " + selectedHero.getDefense() + "\nhp:"
				+ selectedHero.getHitPoints() + "(" + selectedHero.getMaxHitPoints() + ")\nweapon: "
				+ selectedHero.getWeapon() + "\narmor: " + selectedHero.getArmor() + "\nhelm: "
				+ selectedHero.getHelm());
    }

	public int showHeroes(ArrayList<Hero> heroes)
	{
		return (0);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void GUICreationHero()
	{
		this.panel.removeAll();
		this.repaint();
		
		this.setHeroName(new JTextField());
		this.getHeroName().setColumns(20);
		
		this.setClassLst(new JComboBox(heroFactory.classes.values()));
		
		this.setCreateHero(new JButton("Create Hero"));
		
		this.panel.add(this.getHeroName());
		this.panel.add(this.getClassLst());
		this.panel.add(this.getCreateHero());
		this.pack();
	}
	
	public Hero createHero()
	{
		return null;
	}

	public JButton getSelectHero() {
		return selectHero;
	}

	public void setSelectHero(JButton selectHero) {
		this.selectHero = selectHero;
	}

	public JButton getNewHero() {
		return newHero;
	}

	public void setNewHero(JButton newHero) {
		this.newHero = newHero;
	}

	public JButton getCreateHero() {
		return createHero;
	}

	public void setCreateHero(JButton createHero) {
		this.createHero = createHero;
	}

	public JTextField getHeroName() {
		return heroName;
	}

	public void setHeroName(JTextField heroName) {
		this.heroName = heroName;
	}

	public JComboBox getClassLst() {
		return classLst;
	}

	public void setClassLst(JComboBox classLst) {
		this.classLst = classLst;
	}
}