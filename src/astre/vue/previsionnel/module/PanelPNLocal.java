package astre.vue.previsionnel.module;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import astre.Controleur;
import astre.modele.BD;
import astre.modele.elements.Heure;
import astre.modele.elements.Horaire;
import astre.modele.elements.ModuleIUT;
import astre.vue.outils.FiltreTextFieldEntier;

/** Classe PanelPNLocal
  * @author : Clémentin Ly
  * @version : 2.0 - 14/12/2023
  * @date : 12/12/2023
  */

public class PanelPNLocal extends JPanel
{
	/*-------------*/
	/*--Attributs--*/
	/*-------------*/

	private Controleur  ctrl;
	private FrameModule frm;

	private JTextField txtCM;
	private JTextField txtTD;
	private JTextField txtTP;
	private JLabel     lblSomme;

	private JLabel lblTotalCM;
	private JLabel lblTotalTD;
	private JLabel lblTotalTP;
	private JLabel lblTotalSomme;

	//TEST MODULABLE
	private List<JLabel>     lstLabelsHeures     = new ArrayList<>();
	private List<JTextField> lstTextFieldsHeures = new ArrayList<>();

	/*----------------*/
	/*--Constructeur--*/
	/*----------------*/

	public PanelPNLocal(Controleur ctrl, FrameModule frm)
	{
		this.ctrl = ctrl;
		this.frm  = frm;

		/* ------------------------- */
		/* Création des composants   */
		/* ------------------------- */

		this.setLayout ( new GridBagLayout() );
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets ( 5, 5, 5, 5 );

		this.txtCM      = new JTextField ( "", 2 );
		FiltreTextFieldEntier.appliquer ( txtCM );
		this.lstTextFieldsHeures.add ( txtCM );

		this.txtTD      = new JTextField ( "", 2 );
		FiltreTextFieldEntier.appliquer ( txtTD );
		this.lstTextFieldsHeures.add ( txtTD );

		this.txtTP      = new JTextField ( "", 2 );
		FiltreTextFieldEntier.appliquer ( txtTP );
		this.lstTextFieldsHeures.add ( txtTP );
		
		this.lblSomme   = new JLabel();

		this.lblTotalCM    = new JLabel();
		this.lblTotalTD    = new JLabel();
		this.lblTotalTP    = new JLabel();
		this.lblTotalSomme = new JLabel();


		gbc.gridy = 0;
		gbc.gridx = 1;
		this.add ( new JLabel ( "CM" ), gbc );
		this.lstLabelsHeures.add ( new JLabel ( "CM" ) );

		gbc.gridx = 2;
		this.add ( new JLabel ( "TD" ), gbc );
		this.lstLabelsHeures.add ( new JLabel ( "TD" ) );

		gbc.gridx = 3;
		this.add ( new JLabel ( "TP" ), gbc );
		this.lstLabelsHeures.add ( new JLabel ( "TP" ) );

		gbc.gridx = 4;
		this.add ( new JLabel ( "Σ" ), gbc  );


		gbc.gridy = 1;
		gbc.gridx = 1;
		this.add ( this.txtCM, gbc     );

		gbc.gridx = 2;
		this.add ( this.txtTD, gbc     );

		gbc.gridx = 3;
		this.add ( this.txtTP, gbc    );

		gbc.gridx = 4;
		this.add ( this.lblSomme, gbc );


		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add ( new JLabel ( "Total (eqtd) promo" ), gbc );

		gbc.gridx = 1;
		this.add ( this.lblTotalCM, gbc    );

		gbc.gridx = 2;
		this.add ( this.lblTotalTD, gbc    );

		gbc.gridx = 3;
		this.add ( this.lblTotalTP, gbc    );

		gbc.gridx = 4;
		this.add ( this.lblTotalSomme, gbc );

		/* ------------------------- */
		/* Activation des composants */
		/* ------------------------- */

		this.txtCM.addKeyListener ( new AjoutKeyListenerSomme() );
		this.txtTD.addKeyListener ( new AjoutKeyListenerSomme() );
		this.txtTP.addKeyListener ( new AjoutKeyListenerSomme() );


		this.lblSomme.setBackground ( Color.LIGHT_GRAY );
		this.lblSomme.setPreferredSize ( new Dimension ( 40, 15 ) );
		this.lblSomme.setOpaque( true );

		this.lblTotalCM.setBackground ( Color.LIGHT_GRAY );
		this.lblTotalCM.setPreferredSize ( new Dimension ( 40, 15 ) );
		this.lblTotalCM.setOpaque( true );

		this.lblTotalTD.setBackground( Color.LIGHT_GRAY );
		this.lblTotalTD.setPreferredSize( new Dimension ( 40, 15 ) );
		this.lblTotalTD.setOpaque( true );

		this.lblTotalTP.setBackground( Color.LIGHT_GRAY );
		this.lblTotalTP.setPreferredSize( new Dimension ( 40, 15 ) );
		this.lblTotalTP.setOpaque( true );

		this.lblTotalSomme.setBackground( Color.LIGHT_GRAY );
		this.lblTotalSomme.setPreferredSize( new Dimension ( 40, 15 ) );
		this.lblTotalSomme.setOpaque( true );
	}

	private class AjoutKeyListenerSomme implements KeyListener
	{
		public void keyTyped   ( KeyEvent e ) { majSomme();
												majTotalHeure();}
		public void keyPressed ( KeyEvent e ) {}
		public void keyReleased( KeyEvent e ) {}
	}

	private void majSomme()
	{
		try
		{
			int CM    = 0;
			int TD    = 0;
			int TP    = 0;
			
			//TEST MODULABLE
			int nouvHeureValeur = 0;
			
			if (!txtCM.getText().isEmpty() )
			{
				CM = Integer.parseInt ( txtCM.getText() );
			}

			if ( !txtTD.getText().isEmpty() )
			{
				TD = Integer.parseInt ( txtTD.getText() );
			}

			if (!txtTP.getText().isEmpty() )
			{
				TP = Integer.parseInt ( txtTP.getText() );
			}

			int somme = CM + TD + TP;

			//TEST MODULABLE
			for ( JTextField textField : lstTextFieldsHeures )
			{
				if ( !textField.getText().isEmpty() )
				{
					nouvHeureValeur = Integer.parseInt(textField.getText());
					somme += nouvHeureValeur;
				}
			}

			lblSomme.setText ( String.valueOf ( somme ) );


			double totalCM = 0;
			double totalTD = 0;
			double totalTP = 0;

			//TEST MODULABLE
			double nouvTotalHeureValeur = 0;

			if ( !lblTotalCM.getText().isEmpty() )
			{
				totalCM = Double.parseDouble ( lblTotalCM.getText() );
			}

			if ( !lblTotalTD.getText().isEmpty() )
			{
				totalTD = Double.parseDouble ( lblTotalTD.getText() );
			}
			
			if ( !lblTotalTP.getText().isEmpty() )
			{
				totalTP = Double.parseDouble ( lblTotalTP.getText() );
			}

			double totalSomme = totalCM + totalTD + totalTP;

			//TEST MODULABLE
			for ( JLabel labelTotalHeure : lstLabelsHeures )
			{
				if ( !labelTotalHeure.getText().isEmpty() )
				{
					nouvTotalHeureValeur = Double.parseDouble ( labelTotalHeure.getText() );
					totalSomme += nouvTotalHeureValeur;
				}
			}

			lblTotalSomme.setText ( String.valueOf ( totalSomme ) );
		}
		catch ( NumberFormatException ex )
		{
			lblSomme.setText ( "Erreur" );
		}
	}

	private void majTotalHeure()
	{
		try
		{
			int CM = 0;
			int TD = 0;
			int TP = 0;
	
			if ( !txtCM.getText().isEmpty() )
			{
				CM = getCM();
				double coeffCM = coeffHeure ( "CM" );
				double totalCM = CM * coeffCM;
	
				lblTotalCM.setText ( String.valueOf ( totalCM ) );
			}

			if (!txtTD.getText().isEmpty())
			{
				TD = getTD();
				int nbGpTD = frm.getPanelModuleLabel().getNbGpTD();
				double coeffTD = coeffHeure("TD");
				double totalTD = TD * coeffTD * nbGpTD;

				lblTotalTD.setText(String.valueOf(totalTD));
			}

			if ( !txtTP.getText().isEmpty() )
			{
				TP = getTP();
				int nbGpTP = frm.getPanelModuleLabel().getNbGpTP();
				double coeffTP = coeffHeure ( "TP" );
				double totalTP = TP * coeffTP * nbGpTP;
	
				lblTotalTP.setText ( String.valueOf ( totalTP ) );
			}
			
			//TEST MODULABLE
			for ( int i = 0; i < lstTextFieldsHeures.size(); i++)
			{
				JTextField textField       = lstTextFieldsHeures.get(i);
				JLabel     labelTotalHeure = lstLabelsHeures    .get(i);
	
				if ( !textField.getText().isEmpty() )
				{
					//TODO: À MODIFIER CAR AUCUN COEFFICIENT ET AUCUNE MULTIPLICATION AUX ÉTUDIANTS
					int    heureValeur = Integer.parseInt ( textField.getText() );
					labelTotalHeure.setText(String.valueOf( heureValeur ) );
				}
			}
		}
		catch ( NumberFormatException ex )
		{
			lblTotalCM.setText( "Erreur" );
			ex.printStackTrace();
		}
	}
	

	private double coeffHeure ( String nomHeure )
	{
		Heure heure = this.ctrl.getHeure ( nomHeure );

		double coefficient = 0.0;

		switch (nomHeure)
		{
			case "CM":
				coefficient = heure.getCoefTd();
				break;
			case "TD":
				coefficient = heure.getCoefTd();
				break;
			case "TP":
				coefficient = heure.getCoefTd();
				break;
		
			default:
				break;
		}

		return coefficient;
	}

	public void setModule ( ModuleIUT module )
	{
		this.txtCM.setText( "0" );
		this.txtTP.setText( "0" );
		this.txtTD.setText( "0" );
		
		ArrayList<Horaire> lstHoraire = (ArrayList<Horaire>) BD.getInstance().getHoraires( module.getCode() );

		for(Horaire h : lstHoraire)
		{
			switch( h.getHeure().getNom().toUpperCase() )
			{
				case "CM" : this.txtCM.setText( h.getNbHeurePN() + "" ); break;
				case "TP" : this.txtTP.setText( h.getNbHeurePN() + "" ); break;
				case "TD" : this.txtTD.setText( h.getNbHeurePN() + "" ); break;
				default : ;
			}
		}

		majSomme();
		majTotalHeure();
	}

	public int getCM ( ) { return Integer.parseInt( this.txtCM.getText() ); }
	public int getTD ( ) { return Integer.parseInt( this.txtTD.getText() ); }
	public int getTP ( ) { return Integer.parseInt( this.txtTP.getText() ); }


	//TEST MODULABLE
	public void ajouterHeure ( String nomHeure )
	{
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets ( 5, 5, 5, 5 );
	
		JLabel     labelHeure      = new JLabel ( nomHeure );

		JTextField textFieldHeure  = new JTextField ( "", 2 );
		FiltreTextFieldEntier.appliquer ( textFieldHeure );

		JLabel     labelTotalHeure = new JLabel ( );
		labelTotalHeure.setBackground ( Color.LIGHT_GRAY );
		labelTotalHeure.setPreferredSize ( new Dimension ( 40, 15 ) );
		labelTotalHeure.setOpaque( true );
	
		this.lstLabelsHeures    .add ( labelHeure     );
		this.lstTextFieldsHeures.add ( textFieldHeure );
	
		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add ( labelHeure, gbc );
	
		gbc.gridx = 2;
		this.add ( textFieldHeure, gbc );

		gbc.gridx = 3;
		this.add ( labelTotalHeure, gbc );

		textFieldHeure.addKeyListener ( new AjoutKeyListenerSomme() );
	}
}