import java.util.Set;

/**
 * @author Jens Dahlmanns.
 */
public interface Flagged {

	void enable(Set<FieldMode> modes);

	void disable(Set<FieldMode> modes);

	default void update(Set<FieldMode> enableModes, Set<FieldMode> disableModes) {
		this.disable(disableModes);
		this.enable(enableModes);
	}
}
