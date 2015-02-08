without-integrated-tests
========================

Without Integrated Tests: 

http://blog.thecodewhisperer.com/2009/09/30/surely-the-mars-rover-needed-integrated-tests-maybe-not/

Example in Ruby:

http://blog.patchspace.co.uk/the-mars-lander-without-integration-tests-in


A part of the article:

Every time I stub a method, I make an assumption about what values that method can return. To check that assumption, I have to write a test that expects the return value I’ve just stubbed. I use only basic logic there: if A depends on B returning x, then I have to know that B can return x, so I have to write a test for that.