package astre.modele;

/** Classe Semestre 
  * @author : Alizéa LEBARON
  * @version : 1.0 - jj/mm/aaaa (Sauf avec monsieur Seguin ou aaaa-mm-jj)
  */

public class Semestre
{
	private int idSemestre;
	private int nbGroupeTP;
	private int nbGroupeTD;
	private int nbEtudiant;
	private int nbSemaine;

	/*---------------------------------------*/
	/*             CONSTRUCTEUR              */
	/*---------------------------------------*/ 

	/**
	 * @param idSemestre
	 * @param nbGroupeTP
	 * @param nbGroupeTD
	 * @param nbEtudiant
	 * @param nbSemaine
	 */
	public Semestre  (int idSemestre, int nbGroupeTP, int nbGroupeTD, int nbEtudiant, int nbSemaine ) 
	{
		this.idSemestre = idSemestre;
		this.nbGroupeTP = nbGroupeTP;
		this.nbGroupeTD = nbGroupeTD;
		this.nbEtudiant = nbEtudiant;
		this.nbSemaine  = nbSemaine ;
	}

	/*---------------------------------------*/
	/*                GETTEUR                */
	/*---------------------------------------*/ 

	/**
	 * @return the idSemestre
	 */
	public int getIdSemestre ( ) { return idSemestre; }

	/**
	 * @return the nbGroupeTP
	 */
	public int getNbGroupeTP ( ) { return nbGroupeTP; }

	/**
	 * @return the nbGroupeTD
	 */
	public int getNbGroupeTD ( ) { return nbGroupeTD; }

	/**
	 * @return the nbEtudiant
	 */
	public int getNbEtudiant ( ) { return nbEtudiant; }

	/**
	 * @return the nbSemaine
	 */
	public int getNbSemaine ( ) { return nbSemaine; }

	/*---------------------------------------*/
	/*                SETTEUR                */
	/*---------------------------------------*/

	/**
	 * @param idSemestre the idSemestre to set
	 */
	public void setIdSemestre ( int idSemestre ) { this.idSemestre = idSemestre; }

	/**
	 * @param nbGroupeTP the nbGroupeTP to set
	 */
	public void setNbGroupeTP ( int nbGroupeTP ) { this.nbGroupeTP = nbGroupeTP; }

	/**
	 * @param nbGroupeTD the nbGroupeTD to set
	 */
	public void setNbGroupeTD ( int nbGroupeTD ) { this.nbGroupeTD = nbGroupeTD; }

	/**
	 * @param nbEtudiant the nbEtudiant to set
	 */
	public void setNbEtudiant ( int nbEtudiant ) { this.nbEtudiant = nbEtudiant; }

	/**
	 * @param nbSemaine the nbSemaine to set
	 */
	public void setNbSemaine ( int nbSemaine ) { this.nbSemaine = nbSemaine; }

	/*---------------------------------------*/
	/*                METHODES               */
	/*---------------------------------------*/

	/**
	 * @return descriptif des attributs de semestre
	 */
	public String toString ()
	{
		String sRet = "";

		sRet = String.format ( "Nom : %-5d - ",                    this.idSemestre ) +
			   String.format ( "Heure Service Contrat : %02d - ",  this.nbGroupeTD ) +
			   String.format ( "Heure Max Contrat : %02d - ",      this.nbGroupeTP ) +
			   String.format ( "Nombre d'étudiant : %02d",         this.nbEtudiant ) +
			   String.format ( "Nombre de semaine : %02d",         this.nbSemaine  ) ;

		return sRet;
	}
	
}