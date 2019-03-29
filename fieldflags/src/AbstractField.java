import java.util.Set;

/**
 * @author Jens Dahlmanns.
 */
public class AbstractField implements Flagged {

	private final FieldModes modes = FieldModes.readWrite();

	@Override
	public void enable(Set<FieldMode> modes) {
	}

	@Override
	public void disable(Set<FieldMode> modes) {

	}

}
