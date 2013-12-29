package com.enjoysoft;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.junit.Test;

public class PersonTest {
	@Test
	public void canConstructAPersonWithAName() {
		Person person = new Person();
		person.setId(1L);
		person.setName("Larry");

		assertEquals("Larry", person.getName());
		assertEquals(new Long(1), person.getId());
	}

	@Test
	public void testPerson() {
		Session session = HibernateUtils.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();

		Person person = (Person) session.get(Person.class, 1L);
		assertEquals("Larry", person.getName());
		person.setName("Larry");
		session.update(person);
		session.getTransaction().commit();
		HibernateUtils.getSessionFactory().close();
	}

}
