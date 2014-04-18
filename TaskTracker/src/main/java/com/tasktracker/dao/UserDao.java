/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tasktracker.dao;

import com.tasktracker.bean.UserAccount;
import com.tasktracker.error.ProgramCode;
import com.tasktracker.error.TaskTrackerException;
import com.tasktracker.error.UserCode;
import com.tasktracker.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jack
 */
@Repository
public class UserDao {

    private static final Logger logger = Logger.getLogger(UserDao.class);

    /**
     * Attempts to add a UserAccount to the database
     *
     * @param user the UserAccount to add to the database
     * @return the result code
     */
    public boolean addUser(UserAccount user) {
        logger.info("Adding user " + user.toString());
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (ConstraintViolationException ex) {
            logger.error("ConstraintViolationException " + ex.getLocalizedMessage());
            throw new TaskTrackerException(UserCode.DUPLICATE_EMAIL);
        } catch (HibernateException ex) {
            logger.error("HibernateException " + ex.getLocalizedMessage());
            throw new TaskTrackerException(ProgramCode.HIBERNATE_EXCEPTION);
        }
        return true;
    }

    /**
     * Retrieves the UserAccount with the given email address if found,
     * otherwise a null object is returned
     * 
     * @param email
     * @return 
     */
    public UserAccount getUser(String email) {
        logger.debug("Retrieving user " + email);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from UserAccount where email= :email");
            query.setParameter("email", email);
            UserAccount user = (UserAccount) query.uniqueResult();
            transaction.commit();
            if (user == null) {
                logger.warn("User not found");
            } else {
                logger.debug("User found " + user.toString());
            }
            return user;
        } catch (HibernateException ex) {
            logger.error("HibernateException " + ex.getLocalizedMessage());
            return null;
        }
    }

    /**
     * Checks a UserAccount and returns true if is found in the database
     *
     * @param user the UserAccount to check
     * @return if the UserAccount exists in the database or not
     */
    public boolean doesUserExist(UserAccount user) {
        if (getUser(user.getEmail()) == null) {
            return false;
        }
        return true;
    }
    
    
}
