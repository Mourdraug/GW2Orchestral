package org.mordraug.gw2orchestral.Gw2Orchestral.sheet;

import java.util.Comparator;

public final class Note implements Comparator<Note> {

	private int pitch = 0;
	private float length = 1f;
	private float position = 0f;

	/**
	 * Constructs Note instance with default parameters. Useful for testing.
	 */
	public Note() {
	}

	/**
	 * Constructs Note instance with following parameters
	 * 
	 * @param mPitch
	 *            Note pitch, for more detailed info see {@link #setPitch(int)}
	 * @param mLength
	 *            Note length in beats
	 * @param mPosition
	 *            Note position in beats
	 */
	public Note(int mPitch, float mLength, float mPosition) {
		setPitch(mPitch);
		setLength(mLength);
		setPosition(mPosition);
	}

	/**
	 * Sets Note position do desired value.
	 * 
	 * @param mPosition
	 *            desired position in beats, must be equal or greater than 0.
	 * @throws RuntimeException
	 *             thrown if mPosition < 0
	 */
	public void setPosition(float mPosition) throws RuntimeException {
		if (mPosition > 0)
			position = mPosition;
		else
			throw new RuntimeException("Setting note position to negative occured.");
	}

	/**
	 * Returns note position.
	 * 
	 * @return note position in beats.
	 */
	public float getPosition() {
		return position;
	}

	/**
	 * Sets Note length to desired value.
	 * 
	 * @param mLength
	 *            desired length in beats, must be greater than 0.
	 * @throws RuntimeException
	 *             thrown if mLength<=0
	 */
	public void setLength(float mLength) throws RuntimeException {
		if (mLength > 0)
			length = mLength;
		else
			throw new RuntimeException("Setting note length to 0 or less occured.");
	}

	/**
	 * Returns note length.
	 * 
	 * @return note length in beats.
	 */
	public float getLength() {
		return length;
	}

	/**
	 * Sets Note to desired pitch Note that pitch alone does not specify
	 * concrete sound pitch, actual sound differs depending on instrument, it's
	 * best to be viewed as an offset from base note of instrument.
	 * 
	 * @param mPitch
	 *            desired note pitch.
	 */
	public void setPitch(int mPitch) {
		pitch = mPitch;
	}

	/**
	 * Returns note pitch.
	 * 
	 * @return note pitch.
	 */
	public int getPitch() {
		return pitch;
	}

	public Note clone() {
		return new Note(pitch, length, position);
	}

	public int compare(Note note1, Note note2) {
		float position_diff = note1.getPosition() - note2.getPosition();
		if (position_diff != 0)
			return (int) (Math.signum(position_diff) * Math.ceil(Math.abs(position_diff)));
		else
			return note1.getPitch() - note2.getPitch();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(length);
		result = prime * result + pitch;
		result = prime * result + Float.floatToIntBits(position);
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
		Note other = (Note) obj;
		if (Float.floatToIntBits(length) != Float.floatToIntBits(other.length))
			return false;
		if (pitch != other.pitch)
			return false;
		if (Float.floatToIntBits(position) != Float.floatToIntBits(other.position))
			return false;
		return true;
	}

}
