package application;

import java.util.Objects;

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

	public int getRouge() {
		return rouge;
	}

	public int getVert() {
		return vert;
	}

	public int getBleu() {
		return bleu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bleu, nom, rouge, vert);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Couleur other = (Couleur) obj;
		return bleu == other.bleu && Objects.equals(nom, other.nom) && rouge == other.rouge && vert == other.vert;
	}

}
