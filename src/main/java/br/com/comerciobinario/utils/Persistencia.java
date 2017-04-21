package br.com.comerciobinario.utils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;
import org.hibernate.Transaction;

public class Persistencia<T extends Serializable> {
	
	@SuppressWarnings("unused")
	private Transaction transacao;
	@PersistenceContext(unitName = "binario")
	private EntityManager entityManager;
	private final Class<T> persistentClass;
	
	Logger logger = Logger.getLogger( getClass() );
	
	@SuppressWarnings("unchecked")
	public Persistencia(){
		this.entityManager = EntityManagerUtil.getEntityManager();
		this.persistentClass = (Class<T>) ( (ParameterizedType)getClass().getGenericSuperclass() ).getActualTypeArguments()[0];		
	}
	
	protected void insert(T entity) {		
		EntityManager tx = getEntityManager();
        try {
            tx.getTransaction().begin();
            tx.persist(entity);
            tx.getTransaction().commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.getTransaction().rollback();
            logger.error(t);
        }
	}
	
	protected void update(T entity) {		
		EntityManager tx = getEntityManager();
        try {
            tx.getTransaction().begin();
            tx.merge(entity);
            tx.getTransaction().commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.getTransaction().rollback();
            logger.error(t);
        }
	}
	
	protected void delete(T entity) {		
		EntityManager tx = getEntityManager();
        try {
            tx.getTransaction().begin();
            entity = tx.merge(entity);
            tx.remove(entity);
            tx.getTransaction().commit();
            this.entityManager.flush();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.getTransaction().rollback();
            logger.error(t);
        }
	}

	@SuppressWarnings("unchecked")
	public T selecionar(Long id) {
		
		if (id == null || id < 1)
            throw new PersistenceException("Id não pode ser nulo ou negativo");
 
        return (T) entityManager.find(entityManager.getClass(), id);

	}
	
	@SuppressWarnings("unchecked")
	public List<T> listaTodos() throws Exception {
		
		CriteriaQuery<Object> cq = entityManager.getCriteriaBuilder().createQuery();
		cq.select(cq.from(persistentClass));
        return (List<T>) entityManager.createQuery(cq).getResultList();

	}
	
/*	
	@SuppressWarnings("unchecked")
	public ArrayList<T> getListagem() {
		ArrayList<T> todos = new ArrayList<T>();	
		Session session = (Session) getEntityManager().getDelegate();
		builder = session.getCriteriaBuilder();
		todos = (ArrayList<T>) session.createCriteria(persistentClass).list();
		return todos;
	}
	
	@SuppressWarnings({ "unchecked"})
	protected List<T> search(String campo, String condicao,
			String valor, String dataType) {
		List<T> lista = null;
		Criteria criteria = null;
		Session session = (Session) getEntityManager().getDelegate();
		builder = session.getCriteriaBuilder();
		transacao = session.beginTransaction();
		try {
			criteria = session.createCriteria(persistentClass);
			if (dataType.toLowerCase().equals("string")) {
				criteria.add(Restrictions.ilike(campo, valor));
				lista = criteria.list();
			}
			if (dataType.toLowerCase().equals("inteiro")) {
				if (condicao.equals("=")) {
					criteria.add(Restrictions.eq(campo.toLowerCase(),
							Integer.valueOf(valor)));
				} else if (condicao.equals("<>")) {
					criteria.add(Restrictions.ne(campo.toLowerCase(),
							Integer.valueOf(valor)));
				} else if (condicao.equals(">")) {
					criteria.add(Restrictions.gt(campo.toLowerCase(),
							Integer.valueOf(valor)));
				} else if (condicao.equals(">=")) {
					criteria.add(Restrictions.ge(campo.toLowerCase(),
							Integer.valueOf(valor)));
				} else if (condicao.equals("<")) {
					criteria.add(Restrictions.lt(campo.toLowerCase(),
							Integer.valueOf(valor)));
				} else if (condicao.equals("=<")) {
					criteria.add(Restrictions.le(campo.toLowerCase(),
							Integer.valueOf(valor)));
				}
				lista = criteria.list();
			}
			// else{
			// JOptionPane.showMessageDialog(null,
			// "Selecione outro campo para busca");
			// System.exit(0);
			// }
		} catch (HibernateException e) {
			transacao.rollback();
			System.err.println(e.fillInStackTrace());
			logger.error(e);
		} finally {
			session.close();			
		}
		return lista;
	}
*/	
	   
    // Getters para EntityManager
	public EntityManager getEntityManager() {
		this.entityManager = EntityManagerUtil.getEntityManager();
		return entityManager;
	}

}
