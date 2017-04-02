package kr.or.dgit.book_project.view_panel;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import kr.or.dgit.book_project.basic_panel.AbsViewPanel;
import kr.or.dgit.book_project.book_panel.BookInfo;
import kr.or.dgit.book_project.book_panel.BookSearchPanel;
import kr.or.dgit.book_project.dto.PublisherInfo;
import kr.or.dgit.book_project.service.PublisherInfoService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class BookInsertView extends AbsViewPanel implements ActionListener {

	private JButton btnSave;
	private JButton btnCancel;
	private BookInfo pContent;

	public BookInsertView() {

		JPanel panel_5 = new JPanel();
		pMain.add(panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 600, 0 };
		gbl_panel_5.rowHeights = new int[] {300, 50, 200, 0};
		gbl_panel_5.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_5.setLayout(gbl_panel_5);

		pContent = new BookInfo();
		pContent.getBtnAddPublisher().addActionListener(this);
		pContent.getBtnBookSearch().addActionListener(this);
		GridBagConstraints gbc_pContent = new GridBagConstraints();
		gbc_pContent.weighty = 1.0;
		gbc_pContent.weightx = 1.0;
		gbc_pContent.fill = GridBagConstraints.BOTH;
		gbc_pContent.insets = new Insets(0, 0, 5, 0);
		gbc_pContent.gridx = 0;
		gbc_pContent.gridy = 0;
		panel_5.add(pContent, gbc_pContent);

		JPanel pBtn = new JPanel();
		GridBagConstraints gbc_pBtn = new GridBagConstraints();
		gbc_pBtn.weighty = 1.0;
		gbc_pBtn.weightx = 1.0;
		gbc_pBtn.fill = GridBagConstraints.BOTH;
		gbc_pBtn.insets = new Insets(0, 0, 5, 0);
		gbc_pBtn.gridx = 0;
		gbc_pBtn.gridy = 1;
		panel_5.add(pBtn, gbc_pBtn);
		pBtn.setLayout(new GridLayout(1, 0, 20, 10));

		JPanel panel = new JPanel();
		pBtn.add(panel);

		btnSave = new JButton("저장");
		btnSave.addActionListener(this);
		pBtn.add(btnSave);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);

		JPanel panel_1 = new JPanel();
		pBtn.add(panel_1);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.weighty = 1.0;
		gbc_panel_2.weightx = 1.0;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		panel_5.add(panel_2, gbc_panel_2);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pContent.getBtnAddPublisher()) {
			actionPerformedPContentBtnAddPublisher(e);
		}
		if (e.getSource() == pContent.getBtnBookSearch()) {
			actionPerformedPContentBtnBookSearch(e);
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnSave) {
			actionPerformedBtnSave(e);
		}
	}

	protected void actionPerformedBtnSave(ActionEvent e) {
		// 모두 입력되었는지 확인 후
		// 새로운 도서정보가 저장
		// 저장확인메시지
		// 하단에 테이블 데이터 갱신
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		pContent.setClear();
	}

	protected void actionPerformedPContentBtnBookSearch(ActionEvent e) {
		// 도서 검색창 새창으로
		JFrame bookSearch = new JFrame("도서검색");
		bookSearch.setBounds(600, 100, 500, 600);
		bookSearch.getContentPane().add(new BookSearchView());
		bookSearch.setVisible(true);
		// 도서코드 세팅후 enable
	}

	protected void actionPerformedPContentBtnAddPublisher(ActionEvent e) {
		if (pContent.getTfAddPublisher().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "추가할 내용이 없습니다.");
		} else {
			// insert문
			PublisherInfoService pis = new PublisherInfoService();
			PublisherInfo ps = new PublisherInfo();
			ps.setPublisher(pContent.getTfAddPublisher().getText());
			pis.insertPubliherShort(ps);
			List<PublisherInfo> list = pis.selectByAll();
			
			// 추가후... 추가한 항목을 selected로
			
			pContent.getpPublisher().getComboBox().removeAllItems(); // 기존목록 지우기
			pContent.getpPublisher().setComboDate(list); // 새 목록 넣기
			// 목록을 넣지 않고 새로 추가된 애만 additem???? 고민중
			pContent.getpPublisher().setSelected(pis.selectCountAll()-1); // 제일 마지막 출판사 선택하기
			pContent.getTfAddPublisher().setText(""); // 텍스트필드 초기화
		}
	}
}