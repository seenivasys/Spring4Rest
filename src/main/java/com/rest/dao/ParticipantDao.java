package com.rest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rest.model.Participant;


public class ParticipantDao{
	
private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    public List<Participant> selectParticipantList(){
		Session session = this.sessionFactory.openSession();
        List<Participant> participantList = session.createQuery("from Participant").list();
		return participantList;		
	}
    
    public void insertParticipant(Participant participant){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(participant);
		tx.commit();
    }
    
    public boolean deleteParticipant(int id){
    	Session session = this.sessionFactory.openSession();
    	 session.beginTransaction();
         String sql = "DELETE FROM Participant WHERE participant_id ="+id;
         org.hibernate.Query query = session.createQuery(sql);
          int row = query.executeUpdate();
          if (row == 0)
              System.out.println("Doesnt deleted any row!");
          else
              System.out.println("Deleted Row: " + row);
         session.getTransaction().commit(); 
         session.close();
         return row>0;
    }

   
		public boolean updateParticipant(Participant participant) {
		Session session = this.sessionFactory.openSession();
		 session.beginTransaction();
		String sql = "from Participant where id = :pId";
		org.hibernate.Query query = session.createQuery(sql);
		query.setInteger("pId", participant.getpId());
		Object queryResult = query.uniqueResult();
		
		Participant localParticipant = (Participant)queryResult;
		localParticipant.setfName(participant.getfName());
		localParticipant.setlName(participant.getlName());
		localParticipant.setSsn(participant.getSsn());
		
		session.update(localParticipant);
		try {
			session.getTransaction().commit();
		} catch(Exception e){
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
        
		return true;
	}


	public Participant getParticipant(int pId) {
		Session session = this.sessionFactory.openSession();
		String sql = "from Participant where id = :pId";
		org.hibernate.Query query = session.createQuery(sql);
		query.setInteger("pId", pId);
		Object queryResult = query.uniqueResult();
		Participant participant = (Participant)queryResult;
		
		return participant;
	}

}
