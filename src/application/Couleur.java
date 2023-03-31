package application;

public class Couleur {
	
	private String nom;
	private int rouge;
	private int vert;
	private int bleu;
	
	/**
	 * Construit un objet Couleur
	 * @param nom Nom de la couleur
	 * @param rouge Composante rouge
	 * @param vert Composante verte
	 * @param bleu Composante bleue
	 */
	public Couleur(String nom, int rouge, int vert, int bleu) {
		this.nom = nom;
		this.rouge = rouge;
		this.vert = vert;
		this.bleu = bleu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getRouge() {
		return rouge;
	}

	public void setRouge(int rouge) {
		this.rouge = rouge;
	}

	public int getVert() {
		return vert;
	}

	public void setVert(int vert) {
		this.vert = vert;
	}

	public int getBleu() {
		return bleu;
	}

	public void setBleu(int bleu) {
		this.bleu = bleu;
	}
	
}
