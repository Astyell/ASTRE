package astre.vue.previsionnel.module;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import astre.Controleur;

public class PanelModuleLabel  extends JPanel
{
	/*-------------*/
	/*--Attributs--*/
	/*-------------*/

	private Controleur ctrl;

	private JLabel     lblType;
	private JLabel     lblSemestre;
	private JTextField txtCode;
	private JTextField txtLibLong;
	private JTextField txtLibCourt;

	private JLabel lblNbEtd;
	private JLabel lblNbGpTD;
	private JLabel lblNbGpTP;


	/*----------------*/
	/*--Constructeur--*/
	/*----------------*/
	
	public PanelModuleLabel ( Controleur ctrl )
	{
		this.ctrl = ctrl;
		/* ------------------------- */
		/* Création des composants   */
		/* ------------------------- */

		this.setLayout ( new GridLayout( 3, 5 ) );

		this.lblType	 = new JLabel ( );
		this.lblSemestre = new JLabel ( );
		this.txtCode	 = new JTextField ("", 5);
		this.txtLibLong	 = new JTextField ("", 20);
		this.txtLibCourt = new JTextField ("", 10);

		this.add ( new JLabel ( "type module" ) );
		this.add ( new JLabel ( "semestre" ) );
		this.add ( new JLabel ( "code"  ) );
		this.add ( new JLabel ( "libellé long" ) );
		this.add ( new JLabel ( "libellé court" ) );
		
		this.add ( this.lblType     );
		this.add ( this.lblSemestre );
		this.add ( this.txtCode     );
		this.add ( this.txtLibLong  );
		this.add ( this.txtLibCourt );


		this.lblNbEtd  = new JLabel( );
		this.lblNbGpTD = new JLabel( );
		this.lblNbGpTP = new JLabel( );

		this.add ( new JLabel ( "nb Etd : " ) );
		this.add ( this.lblNbEtd  );

		this.add ( new JLabel ( "nb gp TD : " ) );
		this.add ( this.lblNbGpTD );

		this.add ( new JLabel ( "nb gp TP : " ) );
		this.add ( this.lblNbGpTP );

		/* ------------------------- */
		/* Activation des composants */
		/* ------------------------- */

		this.lblType    .setBackground ( Color.LIGHT_GRAY );
		this.lblType    .setPreferredSize ( new Dimension ( 100, 15) );
		this.lblType    .setOpaque ( true );

		this.lblSemestre.setBackground ( Color.LIGHT_GRAY );
		this.lblSemestre.setPreferredSize ( new Dimension ( 50, 15 ) );
		this.lblSemestre.setOpaque ( true );

		this.txtCode.addKeyListener(new KeyListener()
		{
			public void keyTyped    ( KeyEvent e ) { majLabels(); }
			public void keyPressed  ( KeyEvent e ) {}
			public void keyReleased ( KeyEvent e ) {}
		} );


		this.lblNbEtd .setBackground ( Color.LIGHT_GRAY );
		this.lblNbEtd .setPreferredSize ( new Dimension ( 25, 15) );
		this.lblNbEtd .setOpaque ( true );

		this.lblNbGpTD.setBackground ( Color.LIGHT_GRAY );
		this.lblNbGpTD.setPreferredSize ( new Dimension ( 25, 15) );
		this.lblNbGpTD.setOpaque ( true );

		this.lblNbGpTP.setBackground ( Color.LIGHT_GRAY );
		this.lblNbGpTP.setPreferredSize ( new Dimension ( 25, 15) );
		this.lblNbGpTP.setOpaque ( true );
	}

	private void majLabels()
	{
		String code = this.txtCode.getText();

		if ( code.startsWith ( "R" ) )
		{
			this.lblType.setText ( "Ressource" );
		}

		else if ( code.startsWith ( "S" ) )
		{
			this.lblType.setText ( "SAE" );
		}

		else if ( code.contains ( "ST" ) )
		{
			if ( !code.startsWith ( "ST" ) )
			{
				this.lblType.setText ( "Stage" );
			}
		}

		int valSemestre = (code.length() > 1) ? Character.getNumericValue(code.charAt(1)) : -1;

		if (valSemestre >= 1 && valSemestre <= 6)
			this.lblSemestre.setText("S" + valSemestre);
	}
}
