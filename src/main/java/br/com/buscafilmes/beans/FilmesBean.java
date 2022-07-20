package br.com.buscafilmes.beans;

public class FilmesBean {
	// API Filmes
    private String id;
	private String rank;
    private String title;
    private String fullTitle;
    private String year;
    private String image;
    private String crew;
    private String imDbRating;
    private String imDbRatingCount;
    
    // API Nasa
    private String copyright;
    private String date;
    private String explanation;
    private String hdurl;
    private String media_type;
    private String service_version;
    private String url;
    
	public String getId() {
		return id;
	}
	public String getRank() {
		return rank;
	}
	public String getTitle() {
		return title;
	}
	public String getFullTitle() {
		return fullTitle;
	}
	public String getYear() {
		return year;
	}
	public String getImage() {
		return image;
	}
	public String getCrew() {
		return crew;
	}
	public String getImDbRating() {
		return imDbRating;
	}
	public String getImDbRatingCount() {
		return imDbRatingCount;
	}

    public String getCopyright() {
		return copyright;
	}
	public String getDate() {
		return date;
	}
	public String getExplanation() {
		return explanation;
	}
	public String getHdurl() {
		return hdurl;
	}
	public String getMedia_type() {
		return media_type;
	}
	public String getService_version() {
		return service_version;
	}
	public String getUrl() {
		return url;
	}

}