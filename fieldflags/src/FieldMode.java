import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/**
 * @author Jens Dahlmanns.
 */
public enum FieldMode {

	RO(EnumSet.of(FieldFlag.RO)),
	EXTERNAL(EnumSet.of(FieldFlag.EXTERNAL, FieldFlag.RO)),
	CR(EnumSet.of(FieldFlag.CR)),
	MANDATORY(EnumSet.of(FieldFlag.MANDATORY));

	/**
	 * Required flags for this mode.
	 */
	public final Set<FieldFlag> requires;
	/**
	 * Permitted flags for this mode.
	 */
	public final Set<FieldFlag> permits;

	FieldMode(Set<FieldFlag> requires) {
		this(requires, Collections.emptySet());
	}

	FieldMode(Set<FieldFlag> requires, Set<FieldFlag> permits) {
		this.requires = Collections.unmodifiableSet(requires);
		this.permits = Collections.unmodifiableSet(permits);
	}

	public boolean conflicts(FieldMode other) {
		return this.permits.stream().anyMatch(other.requires::contains)
				|| this.permits.stream().anyMatch(other.requires::contains);
	}
}
