package de.bht.swp.ui_prototype.client.hibernate.Model;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IMAGE")
public class Image {

	@Id @GeneratedValue
	private long id;
	
	private String path;

	public long getImageId() {
		return id;
	}

	public void setImageId(long imageId) {
		this.id = imageId;
	}

	public String getImagefile() {
		return path;
	}

	public void setImagefile(String imagepath) {
		this.path = imagepath;
	}

	@Override
	public String toString() {
		return "Image [imageId=" + id + ", imagefile=" + path + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((path == null) ? 0 : path.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Image other = (Image) obj;
		if (id != other.id)
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}
	
	
}
