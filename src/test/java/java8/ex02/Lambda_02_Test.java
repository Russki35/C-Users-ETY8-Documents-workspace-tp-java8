package java8.ex02;

import java8.data.Account;
import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Exercice 02 - Map
 */
public class Lambda_02_Test {

    // tag::PersonToAccountMapper[]
    interface PersonToAccountMapper {
        Account map(Person p);
    }
    // end::PersonToAccountMapper[]

    // tag::map[]
    private List <Account> map(List<Person> personList, PersonToAccountMapper mapper) {
        // TODO implémenter la méthode pour transformer une liste de personnes en liste de comptes
    	
    	// etape 1 => créer une liste de comptes vide
    	List<Account> comptes = new ArrayList<>();
    	// etape 2 => itérer sur la liste de personnes
    	// pour chaque personne	
		// transformer l'objet personne en Account via mapper.map(objPersonne)
		// ajouter l'objet Account à la liste des comptes
    		for (Person p : personList){
    			comptes.add(mapper.map(p));
    		}
    		
    	
    	// etape 3 => retourner la liste de comptes
    	
    	 
        return comptes;
    }
    // end::map[]


    // tag::test_map_person_to_account[]
    @Test
    public void test_map_person_to_account() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // TODO transformer la liste de personnes en liste de comptes
        
        // TODO tous les objets comptes ont un solde à 100 par défaut
        List<Account> comptes = map(personList, p -> {
        	Account a = new Account();
        	a.setOwner(p);
        	a.setBalance(100);
        	return a;
        	
        });
        
        
        assert comptes.size() == personList.size();
        for (Account account : comptes) {
            assert account.getBalance().equals(100);
            assert account.getOwner() != null;
        }
    }
    // end::test_map_person_to_account[]

    // tag::test_map_person_to_firstname[]
    @Test
    public void test_map_person_to_firstname() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // TODO transformer la liste de personnes en liste de prénoms
        List<String> result = null;

        assert result.size() == personList.size();
        for (String firstname : result) {
            assert firstname.startsWith("first");
        }
    }
    // end::test_map_person_to_firstname[]
}
