
public class BirdFavorites 
{

	private boolean isFav;
	private boolean removeFav;
	
	public BirdFavorites()
	{
		isFav = false;
		removeFav = false;
	}
	public BirdFavorites(boolean favorite, boolean notFav)
	{
		isFav = favorite;
		removeFav = notFav;
	}

	public boolean isFav() {
		return isFav;
	}

	public void setFav(boolean isFav) {
		this.isFav = isFav;
	}

	public boolean isRemoveFav() {
		return removeFav;
	}

	public void setRemoveFav(boolean removeFav) {
		this.removeFav = removeFav;
	}
}
