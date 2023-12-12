package astre;

/** Classe Controleur 
  * @author : Maximilien Lesterlin
  * @version : 1.0 - 11/12/2023
  * @date : 06/12/2023
  */

import astre.modele.*;
import astre.modele.bd.*;
import astre.vue.*;
import astre.vue.previsionnel.module.FrameModule;
import astre.vue.outils.PopUpErreur;

public class Controleur
{
	private FrameAccueil ihm;
	private FrameModule  frmModule;
	
	public Controleur ( )
	{
		this.ihm = new FrameAccueil ( this );
	}

	public void ouvrirFrameModule ( )
	{
		this.frmModule = new FrameModule ( this );
	}

	public Semestre getSemestre ( int numSemestre )
	{
		return this.bd.getSemestre ( numSemestre );
	}
	
	public Object[][] getTableauModule ( )
	{
		//à remplacer par une commande de BD
		/*Object[][] tableau = { {"R1.01", "Initia", "437/465", "V"}, {"R2.02", "Dev", "374/374", "V"} };
		return tableau;*/
		
		this.get
		
		return this.bd.getModulesTableau();
	}

	public Object[][] getTableauIntervenant ( )
	{
		return this.bd.getIntervenantsTableau();
	}
	
	public static void afficherErreur ( String titre, String message )
	{
		new PopUpErreur( titre, message );
	}

	public static void main ( String[] args )
	{
		afficherErreur ( "Erreur java", "petite fenetre de test pour afficher les erreurs" );
		new Controleur ( );
	}
}
