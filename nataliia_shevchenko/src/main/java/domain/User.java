package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="users")
public class User {
		@Id
		@GeneratedValue(generator = "increment2")
		@GenericGenerator(name = "increment2", strategy = "increment")
		@Column(name="id")
		private Long id;
		
		@Column(name="name")
		private String name;
		
		@Column(name="login")
		private String login;
		
		@Column(name="pass")
		private String pass;
		
		@Column(name="employee_id")
		private Long empId;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}

		public Long getEmpId() {
			return empId;
		}

		public void setEmpId(Long empId) {
			this.empId = empId;
		}

		public User(String name, String login, String pass, Long empId) {
			this.name = name;
			this.login = login;
			this.pass = pass;
			this.empId = empId;
		}
		
		public User(String name, String login) {
			this.name = name;
			this.login = login;
		}
		
		public User() {}

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", login=" + login + ", pass=" + pass + ", empId=" + empId
					+ "]";
		}
		
		
		
		
}
