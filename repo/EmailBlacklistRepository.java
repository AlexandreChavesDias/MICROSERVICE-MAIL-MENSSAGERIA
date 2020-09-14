@Repository
public interface EmailBlacklistRepository extends JpaRepository<EmailBlacklist, String> {

	@Query("SELECT count(1) FROM EmailBlacklist WHERE email = :email")
	Integer findCountEmailBlacklistByEmail(@Param("email") final String email);

	@Query("SELECT email FROM EmailBlacklist WHERE email in :emailList")
	HashSet<String> findAllEmailByEmailIn(@Param("emailList") final List<String> emailList);
}
