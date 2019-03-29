import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Jens Dahlmanns.
 */
public class FieldModes implements FieldModeConfiguration {

	private final Set<FieldMode> modes;

	private FieldModes(Set<FieldMode> modes) {
		this.modes = modes;
	}

	public static FieldModes readWrite() {
		return new FieldModes(EnumSet.noneOf(FieldMode.class));
	}

	@Override
	public boolean add(FieldMode mode) {
		// TODO: Besser Konflikte returnen?
		if (this.modes.stream().anyMatch(mode::conflicts)) {
			return false;
		}
		this.modes.add(mode);
		return true;
	}

	@Override
	public boolean add(Collection<FieldMode> modes) {
		// TODO: Anderer Returnwert?
		boolean noConflicts = true;
		for (FieldMode mode : modes) {
			if (!this.add(mode)) {
				noConflicts = false;
			}
		}
		return noConflicts;
	}

	@Override
	public void remove(FieldMode mode) {
		this.modes.remove(mode);
	}

	@Override
	public void remove(Collection<FieldMode> modes) {
		modes.forEach(this::remove);
	}

	@Override
	public Set<FieldFlag> getFlags() {
		return this.modes.stream()
				.flatMap(mode -> mode.requires.stream())
				.collect(Collectors.toCollection(() -> EnumSet.noneOf(FieldFlag.class)));
	}

	@Override
	public Set<FieldMode> getModes() {
		return Collections.unmodifiableSet(this.modes);
	}
}
