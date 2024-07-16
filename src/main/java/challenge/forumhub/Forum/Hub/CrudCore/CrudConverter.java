package challenge.forumhub.Forum.Hub.CrudCore;

public interface CrudConverter<E, DTOC, DTOR> {

    E dtoCadToEntity(DTOC dtocad);

    DTOR entityToDTOResponse(E entity);

}