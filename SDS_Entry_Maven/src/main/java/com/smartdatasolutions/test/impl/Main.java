package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main extends MemberFileConverter {

	private Object inputFile;
	@Override
	protected MemberExporter getMemberExporter( ) {
		// TODO
		return new MemberExporterImpl();
	}

	@Override
	protected MemberImporter getMemberImporter( ) {
		// TODO
		return new MemberImporterImpl();
	}

	@Override
	protected List< Member > getNonDuplicateMembers( List< Member > membersFromFile ) {

        Set<Member> memberSet = new HashSet<>(membersFromFile);
        return new ArrayList<>(memberSet);
	}

	@Override
	protected Map< String, List< Member >> splitMembersByState( List< Member > validMembers ) {
		// TODO
		Map<String, List<Member>> stateMap = new HashMap<>();
        for (Member member : validMembers) {
            String state = member.getState();
            if (!stateMap.containsKey(state)) {
                stateMap.put(state, new ArrayList<>());
            }
            stateMap.get(state).add(member);
        }
        return stateMap;
	}

	public static void main( String[] args ) {
		//TODO
		
		
		Main main = new Main();
        try {
            List<Member> members = main.getMemberImporter().importMembers(new File("Members.txt"));
            List<Member> nonDuplicateMembers = main.getNonDuplicateMembers(members);
            Map<String, List<Member>> membersByState = main.splitMembersByState(nonDuplicateMembers);
            for (Map.Entry<String, List<Member>> entry : membersByState.entrySet()) {
                String state = entry.getKey();
                List<Member> stateMembers = entry.getValue();
                String outputFileName = state + "_outputFile.csv";
                try (FileWriter writer = new FileWriter(outputFileName)) {
                    MemberExporter exporter = main.getMemberExporter();
                    for (Member member : stateMembers) {
                        exporter.writeMember(member, writer);
                        writer.write("\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
