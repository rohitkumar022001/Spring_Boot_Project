package com.springBoot.blogApplication.springbootBlogApplication.Entity;
import java.util.List;
import org.hibernate.annotations.ManyToAny;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class Category {
	@Id
	@GeneratedValue(
			strategy=GenerationType.IDENTITY
		)
	int catid;
	String catname;
	@OneToMany(cascade = CascadeType.ALL)
	List<Posts> post;
	public List<Posts> getPost() {
		return post;
	}
	public void setPost(List<Posts> post) {
		this.post = post;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	

}
