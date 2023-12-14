package astre.vue.previsionnel.module;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import astre.Controleur;
import astre.modele.BD;
import astre.modele.elements.Horaire;
import astre.modele.elements.ModuleIUT;

public class PanelPNLocalBis extends JPanel
{
	/*-------------*/
	/*--Attributs--*/
	/*-------------*/

	private Controleur  ctrl;

	private JTextField txtHSae;
	private JTextField txtHTut;
	private JLabel     lblSomme;

	/*----------------*/
	/*--Constructeur--*/
	/*----------------*/

	public PanelPNLocalBis ( Controleur ctrl )
	{
		this.ctrl = ctrl;

		/* ------------------------- */
		/* Création des composants   */
		/* ------------------------- */

		this.setLayout ( new GridBagLayout() );
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets ( 5, 5, 5, 5 );

		this.txtHSae = new JTextField ( "", 2 );
		this.txtHTut = new JTextField ( "", 2 );
		this.lblSomme   = new JLabel();

		gbc.gridy = 0;
		gbc.gridx = 1;
		this.add ( new JLabel ( "h Sae" ), gbc );

		gbc.gridx = 2;
		this.add ( new JLabel ( "h Tut" ), gbc );

		gbc.gridx = 3;
		this.add ( new JLabel ( "Σ" ), gbc  );


		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add ( new JLabel ( "Total (eqtd) promo" ), gbc );

		gbc.gridx = 1;
		this.add ( this.txtHSae, gbc    );

		gbc.gridx = 2;
		this.add ( this.txtHTut, gbc    );

		gbc.gridx = 3;
		this.add ( this.lblSomme, gbc );

		/* ------------------------- */
		/* Activation des composants */
		/* ------------------------- */

		this.txtHSae.addKeyListener ( new AjoutKeyListenerSomme() );
		this.txtHTut.addKeyListener ( new AjoutKeyListenerSomme() );

		this.lblSomme.setBackground ( Color.LIGHT_GRAY );
		this.lblSomme.setPreferredSize ( new Dimension ( 40, 15 ) );
		this.lblSomme.setOpaque( true );
	}

	private class AjoutKeyListenerSomme implements KeyListener
	{
		public void keyTyped   ( KeyEvent e ) { majSomme();}
		public void keyPressed ( KeyEvent e ) {}
		public void keyReleased( KeyEvent e ) {}
	}

	private void majSomme()
	{
		try
		{
			int hSae    = 0;
			int hTut    = 0;

			if (!txtHSae.getText().isEmpty() )
			{
				hSae = Integer.parseInt ( txtHSae.getText() );
			}

			if ( !txtHTut.getText().isEmpty() )
			{
				hTut = Integer.parseInt ( txtHTut.getText() );
			}

			int somme = hSae + hTut;
			lblSomme.setText ( String.valueOf ( somme ) );
		}
		catch ( NumberFormatException ex )
		{
			lblSomme.setText ( "Erreur" );
		}
	}

	public void setModule ( ModuleIUT module )
	{
		this.txtHSae.setText( "0" );
		this.txtHTut.setText( "0" );

		ArrayList<Horaire> lstHoraire = (ArrayList<Horaire>) BD.getInstance().getHoraires( module.getCode() );

		for(Horaire h : lstHoraire)
		{
			switch( h.getHeure().getNom().toUpperCase() )
			{
				case "SAE" : this.txtHSae.setText( h.getNbHeurePN() + "" ); break;
				case "TUT" : this.txtHTut.setText( h.getNbHeurePN() + "" ); break;
				//case "REH" : this.txtTD.setText( h.getNbHeurePN() + "" ); break;
				default : ;
			}
		}

		majSomme();
	}
}