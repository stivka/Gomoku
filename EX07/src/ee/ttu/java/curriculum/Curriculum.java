package ee.ttu.java.curriculum;

import java.util.List;

/**
 * Created by Stiv on 28/03/2017.
 */
public class Curriculum {
    /**
     * Konstruktorisse ette antav thesisEap määrab ära, palju
     * ainepunkte lõputöö saab. Kui lõputöö lisatakse õppekavasse,
     * tuleb sellele ainele määrata vastav EAP-de kogus. Õppekavas
     * saab olla vaid üks lõputöö. Kui lõputöö lisamise ajal on
     * õppekavas juba lõputöö, siis kirjutatakse vana üle.
     * Igalpool, kus EAP on määratud negatiivne, tuleb seda arvestada
     * kui 0. Näiteks kui aine EAP = -3, siis arvesse läheb see aine
     * kui EAP = 0.
     * @param requiredCompulsoryEap
     * @param requiredOptionalEap
     * @param thesisEap
     */
    Curriculum(int requiredCompulsoryEap, int requiredOptionalEap, int thesisEap) {

    }

    /**
     * lisab õppeaine õppekavasse
     * @param subject
     */
    public void addSubject(Subject subject) {

    }

    /**
     *  tagastab järjendi kõikidest õppeainetest (k.a. lõputöö) nende
     *  lisamise järjekorras (esimesena lisatud aine on esimene,
     *  teisena lisatud aine on teine jne). Kui lõputöö kirjutatakse üle
     *  (vt allpool täpsustust), siis uus lõputöö lisatakse kõige
     *  viimaseks (vana lõputöö eemaldatakse järjendist).
     * @return
     */
    public List<Subject> getAllSubjects() {

        return null;
    }

    /**
     * tagastab valikained nende lisamise järjekorras
     * @return
     */
    public List<OptionalSubject> getOptionalSubjects() {

        return null;
    }

    /**
     * tagastab kohustuslikud ained nende lisamise järjekorras.
     * @return
     */
    public List<CompulsorySubject> getCompulsorySubjects() {

        return null;
    }

    /**
     * tagastab lõputöö objekti; õppekavas saab olla vaid üks lõputöö
     * @return
     */
    public Thesis getThesis() {

        return null;
    }

    /**
     * tagastab õppekava summaarse EAP-de koguse
     * @return
     */
    public int getTotalEap() {

        return 0;
    }

    /**
     * tagastab true, kui õppekava on täidetud. Kasutada tuleb
     * konstruktoris ette antud vajalikke EAP koguseid (kohustuslike
     * ja valikainete osas). Lisaks peab õppekava ainete hulgas olema
     * lõputöö.
     * @return
     */
    public boolean isComplete() {

        return false;
    }
}
