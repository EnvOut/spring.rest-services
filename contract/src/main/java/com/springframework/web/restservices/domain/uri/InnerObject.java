package com.springframework.web.restservices.domain.uri;

import com.springframework.web.restservices.domain.contract.parser.InnerObjectType;
import com.springframework.web.restservices.domain.contract.util.IdentifierUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * /users/1/roles
 */
@RequiredArgsConstructor
public class InnerObject {

    @Getter
    private final String name;
    private final String identifier;

    public static LinkedList<InnerObject> from(List<String> pathList) {
        final LinkedList<InnerObject> results = new LinkedList<>();

        int size = pathList.size();
        for (int i = 0; i < size; i++) {
            String currentItemName = pathList.get(i);
            String identifier = Optional.of(i + 1)
                    .filter(it -> it < size)
                    .map(pathList::get)
                    .filter(it -> IdentifierUtils.isDigits(it) || IdentifierUtils.isUUID(it))
                    .orElse(null);

            results.add(new InnerObject(currentItemName, identifier));
            // skip one if next is identifier
            if (identifier != null) {
                i++;
            }
            // go next
            i++;
        }

        return results;
    }

    public InnerObjectType getType() {
        return (identifier == null || identifier.isEmpty()) ? InnerObjectType.COLLECTION : InnerObjectType.SINGLE;
    }
}
