package koitt.ratta.doeat.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Users {

	@Id
	@Column
	private String username;
	@Column
	private String password; //인코딩된 비밀번호
	@Column
	private int enable;
}
