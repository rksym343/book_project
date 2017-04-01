package kr.or.dgit.book_project.view_panel;

import javax.swing.JPanel;
import java.awt.GridLayout;

import kr.or.dgit.book_project.basic_panel.AbsViewPanel;
import kr.or.dgit.book_project.book_panel.BookSearchPanel;
import kr.or.dgit.book_project.book_panel.CheckSearchDesign;

import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;

public class BookSearchView extends AbsViewPanel {

	public BookSearchView() {
		
		
		
		JPanel pMainSub = new JPanel();
		pMain.add(pMainSub);
		GridBagLayout gbl_pMainSub = new GridBagLayout();
		gbl_pMainSub.columnWidths = new int[] {300, 0};
		gbl_pMainSub.rowHeights = new int[] {200, 200, 0};
		gbl_pMainSub.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pMainSub.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pMainSub.setLayout(gbl_pMainSub);
		
		CheckSearchDesign pContent = new CheckSearchDesign();
		GridBagConstraints gbc_pContent = new GridBagConstraints();
		gbc_pContent.weighty = 1.0;
		gbc_pContent.weightx = 1.0;
		gbc_pContent.fill = GridBagConstraints.BOTH;
		gbc_pContent.insets = new Insets(0, 0, 5, 0);
		gbc_pContent.gridx = 0;
		gbc_pContent.gridy = 0;
		pMainSub.add(pContent, gbc_pContent);
		GridBagLayout gbl_pContent = (GridBagLayout) pContent.getLayout();
		gbl_pContent.rowHeights = new int[]{227};
		
		BookSearchPanel bsp = new BookSearchPanel();
		pContent.getpContent().add(bsp);
		
		JPanel pTable = new JPanel();
		GridBagConstraints gbc_pTable = new GridBagConstraints();
		gbc_pTable.weighty = 1.5;
		gbc_pTable.weightx = 1.0;
		gbc_pTable.fill = GridBagConstraints.BOTH;
		gbc_pTable.gridx = 0;
		gbc_pTable.gridy = 1;
		pMainSub.add(pTable, gbc_pTable);
	}

}
