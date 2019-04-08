package dao;


import model.User;
import org.hibernate.Session;
import usermangement.IPasswordHashing;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class AccessUserImpl implements AccessUser {

    @PersistenceContext(unitName = "postgres")
    private EntityManager em;

    @Inject
    private IPasswordHashing passwordHashing;

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUser(long key) {
        return em.find(User.class, key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUserByEmail(String email) {
        Session session = em.unwrap(Session.class);
        return session.bySimpleNaturalId(User.class).load(email);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<User> loginByEmail(String email, String password) {
        User user = getUserByEmail(email);
        if (user != null && passwordHashing.checkPasswd(user.getPassword(), password))
            return Optional.of(user);
        else
            return Optional.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void register(User user) {
        em.persist(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean changePassword(User user, String oldPassword, String newPassword) {
        if (!passwordHashing.checkPasswd(user.getPassword(), oldPassword)) {
            return false;
        }
        user.setPassword(passwordHashing.hash(newPassword));
        return true;
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

}

