package com.batch.sample.DepositProcessor.persistance.hibernate;

import java.util.List;

import com.batch.sample.DepositProcessor.domain.DepositDetails;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.batch.sample.DepositProcessor.persistance.DAO.DepositDetailsDAO;

/**
 * @author alex.d.ley
 *
 */

@SuppressWarnings("rawtypes")
@Repository("depositDetailsDAO")
public class HibernateDepositDetailsDAO extends AbstractHibernateDAO implements DepositDetailsDAO {

	@SuppressWarnings("unchecked")
	public HibernateDepositDetailsDAO(){
		setClazz(DepositDetails.class);
	}

	public List<DepositDetails> findbyAccountID(Integer accountId) {
		//validate the input
		if(accountId != null){
			//create a criteria that specifies the account ID to search for
			Criteria criteria = getCurrentSession().createCriteria(getClazz());
			criteria.add(Restrictions.eq("account_id", accountId));
			@SuppressWarnings("unchecked")
			//get the results into a list and check that results were returned
			List<DepositDetails> results = criteria.list();
			if(results != null){
				if(results.size() != 0){
					//yes we had results, so send them back to the caller
					return results;
				}else{
					return null;
				}
			}else{
				return null;
			}
			
		}else{
			return null;
		}
	}
	

}
