import java.util.Collection;
import java.util.Set;

/**
 * @author Jens Dahlmanns.
 */
public interface FieldModeConfiguration {
	boolean add(FieldMode mode);

	boolean add(Collection<FieldMode> modes);

	void remove(FieldMode mode);

	void remove(Collection<FieldMode> modes);

	Set<FieldFlag> getFlags();

	Set<FieldMode> getModes();
}
