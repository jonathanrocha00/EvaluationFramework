import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import control.EvaluationManagerSingleton;
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
		EvaluableItem item = new EvaluableItem(1, "UFRN", "Universidade Federal do Rio Grande do Norte");
		evaluableItemDao.insert(item);
		
		List<EvaluableItem> items = evaluableItemDao.searchAll();
		System.out.println("Itens: ");
		Iterator<EvaluableItem> it2 = items.iterator();
		while(it2.hasNext()) {
			EvaluableItem e = it2.next();
			System.out.println("\t" + e.getName());
		}
		
		EvaluableItem item222 = new EvaluableItem(1, "UFRNN", "universidade federal do rn");
		evaluableItemDao.update(item222);
		
		items = evaluableItemDao.searchAll();
		System.out.println("Itens: ");
		Iterator<EvaluableItem> it222 = items.iterator();
		while(it222.hasNext()) {
			EvaluableItem f = it222.next();
			System.out.println("\t" + f.getName());
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
		SubjectiveCriterion sub = new SubjectiveCriterion(1, "nome", "descricao", "gostei");
		list1.add(sub);
		
		List<ObjectiveCriterion> list2 = new ArrayList<ObjectiveCriterion>();
		ObjectiveCriterion ob = new ObjectiveCriterion(1, "nome", "descricao", 0, CriterionType.BOOL);
		list2.add(ob);
		
		Date data = new GregorianCalendar(2017, Calendar.JUNE, 4).getTime();
		
		EvaluationManagerSingleton.getInstance().evaluateItem(item, user, list1, list2, data);
		
		List<ItemEvaluation> itemev = EvaluationManagerSingleton.getInstance().getAllItemEvaluations();
		
		Iterator<ItemEvaluation> it4 = itemev.iterator();
		while (it4.hasNext()){
			ItemEvaluation ue = it4.next();
			System.out.println("\tItem:" + ue.getEvaluatedItem().getName());
			System.out.println("\tUsuário:" + ue.getUser().getName());
			System.out.println("\tCritério Objetivo:" + ue.getObjectiveCriteria().get(0).getRate());
			System.out.println("\tCritério Subjtivo:" + ue.getSubjectiveCriteria().get(0).getComment());
			System.out.println("\tData::" + ue.getDate());
		}
		
		// ================
		System.out.println("Avaliação de Usuário Avaliável: ");
		List<SubjectiveCriterion> list3 = new ArrayList<SubjectiveCriterion>();
		SubjectiveCriterion sub1 = new SubjectiveCriterion(1, "nome", "descricao", "gostei");
		list1.add(sub1);
		
		List<ObjectiveCriterion> list4 = new ArrayList<ObjectiveCriterion>();
		ObjectiveCriterion ob2 = new ObjectiveCriterion(1, "nome", "descricao", 0, CriterionType.BOOL);
		list2.add(ob2);
		
		Date data2 = new GregorianCalendar(2017, Calendar.JUNE, 4).getTime();
		
		EvaluationManagerSingleton.getInstance().evaluateUser(eUser, user, list1, list2, data);
		
		List<UserEvaluation> userev = EvaluationManagerSingleton.getInstance().getAllUserEvaluations();
		
		Iterator<UserEvaluation> it5 = userev.iterator();
		while (it5.hasNext()){
			UserEvaluation ue = it5.next();
			System.out.println("\tItem:" + ue.getEvaluatedItem().getName());
			System.out.println("\tUsuário:" + ue.getUser().getName());
			System.out.println("\tCritério Objetivo:" + ue.getObjectiveCriteria().get(0).getRate());
			System.out.println("\tCritério Subjtivo:" + ue.getSubjectiveCriteria().get(0).getComment());
			System.out.println("\tData::" + ue.getDate());
		}
		
	}
}
