using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace HappyCommunity.Types
{
	public class PostOverviewModel
	{
        public long Id { get; set; }
        public string Title { get; set; }
        public int Reward { get; set; }
        public string Creator { get; set; }
		public string City { get; set; }

	}
}
