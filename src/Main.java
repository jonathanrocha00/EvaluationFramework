import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import dao.EvaluableItemDao;
import dao.EvaluableUserDao;
import dao.UserDao;
import model.CriterionType;
import model.EvaluableItem;
import model.EvaluableUser;
import model.ItemEvaluation;
import model.ObjectiveCriterion;
import model.SubjectiveCriterion;
import model.User;
import model.UserEvaluation;

public class Main {
	public static void main (String [] args){
		System.out.println("Evaluation Framework");
		
		// ==================
		UserDao userDao = new UserDao();
		User user = new User("carlosant");
		User user2 = new User("jonathanrocha");
		
		userDao.insert(user);
		userDao.insert(user2);
		
		List<User> usuarios = userDao.searchAll();
		System.out.println("Usuários: ");
		Iterator<User> it = usuarios.iterator();
		while(it.hasNext()) {
			User u = it.next();
			System.out.println("\t" + u.getName());
		}
		
		// ==================
		EvaluableItemDao evaluableItemDao = new EvaluableItemDao();
		EvaluableItem item = new EvaluableItem("UFRN", "Universidade Federal do Rio Grande do Norte");
		evaluableItemDao.insert(item);
		
		List<EvaluableItem> items = evaluableItemDao.searchAll();
		System.out.println("Itens: ");
		Iterator<EvaluableItem> it2 = items.iterator();
		while(it2.hasNext()) {
			EvaluableItem e = it2.next();
			System.out.println("\t" + e.getName());
		}
		
		// ==================
		EvaluableUserDao evaluableUserDao = new EvaluableUserDao();
		EvaluableUser eUser = new EvaluableUser("Joao", "Professor joao");
		evaluableUserDao.insert(eUser);
		
		List<EvaluableUser> eUsers = evaluableUserDao.searchAll();
		System.out.println("Usuários Avaliáveis: ");
		Iterator<EvaluableUser> it3 = eUsers.iterator();
		while(it3.hasNext()) {
			EvaluableUser e = it3.next();
			System.out.println("\t" + e.getName());
		}
		
		// =================
		System.out.println("Avaliação de Item: ");
		List<SubjectiveCriterion> list1 = new ArrayList<SubjectiveCriterion>();
		SubjectiveCriterion sub = new SubjectiveCriterion("nome", "descricao", "gostei");
		list1.add(sub);
		
		List<ObjectiveCriterion> list2 = new ArrayList<ObjectiveCriterion>();
		ObjectiveCriterion ob = new ObjectiveCriterion("nome", "descricao", 0, CriterionType.BOOL);
		list2.add(ob);
		
		Date data = new GregorianCalendar(2017, Calendar.JUNE, 4).getTime();
		
		ItemEvaluation itemev = new ItemEvaluation(item, user, list1, list2, data);
		System.out.println("\tItem: " + itemev.getEvaluatedItem().getName());
		System.out.println("\tUsuário: " + itemev.getUser().getName());
		System.out.println("\tCritério Objetivo: " + itemev.getObjectiveCriteria().get(0).getRate());
		System.out.println("\tCritério Subjetivo: " + itemev.getSubjectiveCriteria().get(0).getComment());
		System.out.println("\tData: " + itemev.getDate());
		
		// ================
		System.out.println("Avaliação de Usuário Avaliável: ");
		List<SubjectiveCriterion> list3 = new ArrayList<SubjectiveCriterion>();
		SubjectiveCriterion sub1 = new SubjectiveCriterion("nome", "descricao", "gostei");
		list1.add(sub1);
		
		List<ObjectiveCriterion> list4 = new ArrayList<ObjectiveCriterion>();
		ObjectiveCriterion ob2 = new ObjectiveCriterion("nome", "descricao", 0, CriterionType.BOOL);
		list2.add(ob2);
		
		Date data2 = new GregorianCalendar(2017, Calendar.JUNE, 4).getTime();
		
		UserEvaluation userev = new UserEvaluation(eUser, user, list1, list2, data);
		System.out.println("\tItem: " + userev.getEvaluatedItem().getName());
		System.out.println("\tUsuário: " + userev.getUser().getName());
		System.out.println("\tCritério Objetivo: " + userev.getObjectiveCriteria().get(0).getRate());
		System.out.println("\tCritério Subjetivo: " + userev.getSubjectiveCriteria().get(0).getComment());
		System.out.println("\tData: " + userev.getDate());
		
		
	}
}
