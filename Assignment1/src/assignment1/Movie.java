package assignment1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Movie {

	private JFrame frame;
	private JTextField txtMovieName;
	private JTextField txtDate;
	private JTextField txtDab;
	private ArrayList goodGreatMovie;
	private BufferedImage emoji;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movie window = new Movie();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Movie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Good Movie Rater Database Yes Good Okay!!");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Old English Text MT", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(49, 11, 388, 51);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblMovieName = new JLabel("Movie Name:");
		lblMovieName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 7));
		lblMovieName.setBounds(73, 81, 69, 14);
		frame.getContentPane().add(lblMovieName);
		
		JLabel lblRating = new JLabel("Rating:");
		lblRating.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblRating.setBounds(73, 126, 69, 14);
		frame.getContentPane().add(lblRating);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(73, 169, 69, 14);
		frame.getContentPane().add(lblDate);
		
		JLabel lblWouldYouTake = new JLabel("Would You Take The Fam:");
		lblWouldYouTake.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWouldYouTake.setBounds(73, 214, 132, 14);
		frame.getContentPane().add(lblWouldYouTake);
		
		JLabel lblHowManyDabs = new JLabel("How Many Dabs Taken:");
		lblHowManyDabs.setBounds(73, 256, 132, 14);
		frame.getContentPane().add(lblHowManyDabs);
		
		JLabel lblFidgetSpinnerTime = new JLabel("Fidget Spinner TIme:");
		lblFidgetSpinnerTime.setBounds(73, 295, 132, 14);
		frame.getContentPane().add(lblFidgetSpinnerTime);
		
		JLabel lblAdditionalComments = new JLabel("Additional Comments:");
		lblAdditionalComments.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAdditionalComments.setBounds(73, 339, 132, 14);
		frame.getContentPane().add(lblAdditionalComments);
		
		txtMovieName = new JTextField();
		txtMovieName.setBounds(214, 78, 200, 20);
		frame.getContentPane().add(txtMovieName);
		txtMovieName.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(214, 166, 200, 20);
		frame.getContentPane().add(txtDate);
		
		txtDab = new JTextField();
		txtDab.setColumns(10);
		txtDab.setBounds(215, 253, 200, 20);
		frame.getContentPane().add(txtDab);
		
		JComboBox cbxRating = new JComboBox();
		cbxRating.setModel(new DefaultComboBoxModel(new String[] {"Black Woman", "Brown Pedophile", "White Pedophile", "Blonde Child", "Asian Child", "White Child"}));
		cbxRating.setBounds(214, 123, 200, 20);
		frame.getContentPane().add(cbxRating);
		
		JComboBox cbxFam = new JComboBox();
		cbxFam.setModel(new DefaultComboBoxModel(new String[] {"True", "False"}));
		cbxFam.setBounds(215, 211, 200, 20);
		frame.getContentPane().add(cbxFam);
		
		JComboBox cbxFidget = new JComboBox();
		cbxFidget.setModel(new DefaultComboBoxModel(new String[] {"12.0f", "7.0f", "0.2f", "800,000,000.0f"}));
		cbxFidget.setBounds(215, 292, 200, 20);
		frame.getContentPane().add(cbxFidget);
		
		JComboBox cbxComments = new JComboBox();
		cbxComments.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No", "Maybe", "Don't Know", "Prefer Not To Say", "Movie Was Good", "Children Were In The Way"}));
		cbxComments.setBounds(215, 336, 200, 20);
		frame.getContentPane().add(cbxComments);
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnAdd = new JButton("Add Movie");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GoodGoodFilm tempGoodMovieYesOk = new GoodGoodFilm(txtMovieName.getText(), cbxRating.getSelectedItem().toString(), txtDate.getText(), returnDAB((String)cbxFam.getSelectedItem()), Integer.parseInt(txtDab.getText()), Float.parseFloat((String)cbxFidget.getSelectedItem()), (String)cbxComments.getSelectedItem());
								
				String dbUrl = "jdbc:mysql://localhost:3306/mydb";
				String user = "root";
				String password = "";
				
				try {
					Connection myConn = DriverManager.getConnection(dbUrl, user, password);
										
					String query = "insert into goodgreatmovie(MovieName, Rating, Date, Fam, Dabs, Fidget, Comments)" + " values(?, ?, ?, ?, ?, ?, ?)"; 
					
					PreparedStatement preparedStmt = myConn.prepareStatement(query);
					preparedStmt.setString(1, tempGoodMovieYesOk.getMovieName());
					preparedStmt.setString(2, tempGoodMovieYesOk.getRating());
					preparedStmt.setString(3, tempGoodMovieYesOk.getReleaseDate());
					preparedStmt.setBoolean(4, tempGoodMovieYesOk.isWouldYouTakeTheFam());
					preparedStmt.setInt(5, tempGoodMovieYesOk.getHowManyDabsTaken());
					preparedStmt.setFloat(6, tempGoodMovieYesOk.getFidgetSpinnerTime());
					preparedStmt.setString(7, tempGoodMovieYesOk.getAdditionalComments());
					
					preparedStmt.execute();
					
					myConn.close();
				
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnAdd.setBackground(Color.YELLOW);
		btnAdd.setForeground(Color.BLUE);
		btnAdd.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		btnAdd.setBounds(159, 390, 155, 44);
		frame.getContentPane().add(btnAdd);
	}
	
	private boolean returnDAB(String dabStringDab)
	{
		if(dabStringDab.equals("True"))
			return true;
		else
			return false;
	}
}


enum emoji {
	BLACKWOMAN, BROWNPEDO, WHITEPEDO, BLONDECHILD, ASIANCHILD, WHITECHILD, DOGFILTER 
}
