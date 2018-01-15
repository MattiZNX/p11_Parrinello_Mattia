import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	UC1_Autenticarsi.class,
	UC2_Logout.class,
	UC3_Registrazione.class,
	UC4_Ricerca.class, 
	UC5_ConsultareSchedaFilm.class,
	UC6_ScrivereRecensioni.class,
	UC7_AcquistareBiglietti.class,
	UC8_CancellarePrenotazioni.class,
	UC9_AcquistareAbbonamenti.class,
	UC10_ModificaDatiPersonali.class,
	UC12_AggiungereFilm.class,
	UC13_EliminaFilmDallaProgrammazione.class,
	UC14_ModificareProgrammazione.class,
	UC17_AggiungereCassiera.class,
	UC18_EliminaCassiera.class
})
public class JUnitSuite {

}
