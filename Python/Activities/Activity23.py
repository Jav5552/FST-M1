import pytest

@pytest.fixture
def List_Of_Numbers():
    list = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 
    return list


def test_sum(List_Of_Numbers):
    sum=0
     
    # Add number in the list
    for n in List_Of_Numbers:
        sum += n
 
    # Assertion
    assert sum == 55