package de.bht.swp.ui_prototype.client.hibernate.Mapping;

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
	@Column(name = "IMAGE_ID")
	private long imageId;
	
	@Column(name = "PATH")
	private File imagefile;

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	public File getImagefile() {
		return imagefile;
	}

	public void setImagefile(File imagefile) {
		this.imagefile = imagefile;
	}

	@Override
	public String toString() {
		return "Image [imageId=" + imageId + ", imagefile=" + imagefile + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (imageId ^ (imageId >>> 32));
		result = prime * result
				+ ((imagefile == null) ? 0 : imagefile.hashCode());
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
		if (imageId != other.imageId)
			return false;
		if (imagefile == null) {
			if (other.imagefile != null)
				return false;
		} else if (!imagefile.equals(other.imagefile))
			return false;
		return true;
	}
	
	
}
