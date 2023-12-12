package astre.modele.elements;

/** Classe Module 
  * @author : Maximilien Lesterlin
  * @version : 1.0.1 - 12/12/2023
  * @date : 06/12/2023
  */

import java.util.Map;

public class ModuleIUT
{
<<<<<<< HEAD:src/astre/modele/elements/ModuleIUT.java
	Map<Heure, Integer> hmHeuresPn;
	Map<Heure, Integer> hmHeuresRepaties;
	
=======
	HashMap<Heure, Integer> hsHeuresPn;
	HashMap<Heure, Integer> hsHeuresRepariees;
	

>>>>>>> ced1187eefce22079ca604cebe1c9b920a5912c3:src/astre/modele/elements/Module.java
	Semestre   semestre;
	TypeModule typeModule;
	String     code;
	String     libLong;
	String     libCourt;
	boolean    valide;

	public ModuleIUT ( Semestre semestre, TypeModule typeModule, String code, String libLong, String libCourt, Map<Heure, Integer> hmHeuresPn, Map<Heure, Integer> hmHeuresRepaties )
	{
		this.semestre          = semestre;
		this.typeModule        = typeModule;
		this.code              = code;
		this.libLong           = libLong;
		this.libCourt          = libCourt;
		this.valide            = false;
		this.hmHeuresPn        = hmHeuresPn;
		this.hmHeuresRepaties  = hmHeuresRepaties;
	}

	/*---------------------------------------*/
	/*                GETTEUR                */
	/*---------------------------------------*/

	public boolean             estValide             ( ) { return this.valide;            }
	public Semestre            getSemestre           ( ) { return this.semestre;          }
	public TypeModule          getTypeModule         ( ) { return this.typeModule;        }
	public String              getCode               ( ) { return this.code;              }
	public String              getLibLong            ( ) { return this.libLong;           }
	public String              getLibCourt           ( ) { return this.libCourt;          }
	public Map<Heure, Integer> getHmHeureReparties   ( ) { return this.hmHeuresRepaties; }
	public Map<Heure, Integer> getHmHeurePn          ( ) { return this.hmHeuresPn;        }

	public int getHeureReparties ( )
	{
		int somme = 0;
		
		for ( Heure h : this.hmHeuresRepaties.keySet ( ) )
			somme += this.hmHeuresRepaties.get ( h );

		return somme;
	}

	public int getHeurePn ( )
	{
		int somme = 0;
		
		for ( Heure h : this.hmHeuresPn.keySet ( ) )
			somme += this.hmHeuresPn.get ( h );

		return somme;
	}


	/*---------------------------------------*/
	/*                SETTEUR                */
	/*---------------------------------------*/

	public void setSemestre   ( Semestre   semestre   ) { this.semestre   = semestre;   }
	public void setTypeModule ( TypeModule typeModule ) { this.typeModule = typeModule; }
	public void setCode       ( String     code       ) { this.code       = code;       }
	public void setLibLong    ( String     libLong    ) { this.libLong    = libLong;    }
	public void setLibCourt   ( String     libCourt   ) { this.libCourt   = libCourt;   }
	public void setValide     ( boolean    choix      ) { this.valide     = choix;      }

	@Override
	public String toString()
	{
		return "ModuleIUT [hmHeuresPn=" + hmHeuresPn + ", hmHeuresRepaties=" + hmHeuresRepaties + ", semestre="
				+ semestre + ", typeModule=" + typeModule + ", code=" + code + ", libLong=" + libLong + ", libCourt="
				+ libCourt + ", valide=" + valide + "]";
	}

	
}
