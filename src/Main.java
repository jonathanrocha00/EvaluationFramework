import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import control.EvaluationManagerSingleton;
import control.Test;
import control.Test2;
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
		
		ArrayList<SubjectiveCriterion> list1 = new ArrayList<SubjectiveCriterion>();
		SubjectiveCriterion sub = new SubjectiveCriterion(1, "O quanto é bom?", "Descreva o quanto é bom...", null);
		list1.add(sub);
		
		ArrayList<ObjectiveCriterion> list2 = new ArrayList<ObjectiveCriterion>();
		ObjectiveCriterion ob = new ObjectiveCriterion(1, "Nota", "Dê uma nota...", 0, CriterionType.BOOL);
		list2.add(ob);
		
		EvaluableItem item = new EvaluableItem(1, "UFRN", "Universidade Federal do Rio Grande do Norte", list2, list1);
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
		EvaluableUser eUser = new EvaluableUser("Joao", "Professor joao", list2, list1);
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
		
		Date data = new GregorianCalendar(2017, Calendar.JUNE, 4).getTime();
		Test test = new Test();
		
		List<String> comentarios = new ArrayList<String>();
		comentarios.add("É muito bom!!");
		List<Integer> rates = new ArrayList<Integer>();
		rates.add(1);
		
		EvaluationManagerSingleton.getInstance().evaluateItem(test, item, user2, comentarios, rates, data);
		
		List<ItemEvaluation> itemev = EvaluationManagerSingleton.getInstance().getAllItemEvaluations();
		
		Iterator<ItemEvaluation> it4 = itemev.iterator();
		while (it4.hasNext()){
			ItemEvaluation ue = it4.next();
			System.out.println("\tItem:" + ue.getEvaluatedItem().getName());
			System.out.println("\tUsuário:" + ue.getUser().getName());
			System.out.println("\tCritério Objetivo:" + ue.getComments().get(0));
			System.out.println("\tCritério Subjtivo:" + ue.getRates().get(0));
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
		
		Test2 test2 = new Test2();
		
		EvaluationManagerSingleton.getInstance().evaluateUser(test2, eUser, user, comentarios, rates, data);
		
		List<UserEvaluation> userev = EvaluationManagerSingleton.getInstance().getAllUserEvaluations();
		
		Iterator<UserEvaluation> it5 = userev.iterator();
		while (it5.hasNext()){
			UserEvaluation ue = it5.next();
			System.out.println("\tItem:" + ue.getEvaluatedItem().getName());
			System.out.println("\tUsuário:" + ue.getUser().getName());
			System.out.println("\tCritério Objetivo:" + ue.getComments().get(0));
			System.out.println("\tCritério Subjtivo:" + ue.getRates().get(0));
			System.out.println("\tData::" + ue.getDate());
		}
		
	}
}
